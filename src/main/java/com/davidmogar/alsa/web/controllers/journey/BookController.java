package com.davidmogar.alsa.web.controllers.journey;

import com.davidmogar.alsa.domain.bus.IdentificationType;
import com.davidmogar.alsa.dto.journey.ReservationDto;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import com.davidmogar.alsa.infraestructure.utils.NumberUtils;
import com.davidmogar.alsa.services.journey.ReservationManagerService;
import com.davidmogar.alsa.services.schedule.ScheduleManagerService;
import com.davidmogar.alsa.web.data.EmailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("journey")
@SessionAttributes("reservation")
public class BookController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ReservationManagerService reservationManagerService;

    @Autowired
    private ScheduleManagerService scheduleManagerService;

    @RequestMapping(value = "book", method = RequestMethod.GET)
    public String showBookHome(@RequestParam Long oneWayId, @RequestParam(required = false) Optional<Long> returnId,
                               @ModelAttribute("reservation") ReservationDto reservationDto, Model model) {
        ScheduleDto oneWaySchedule = scheduleManagerService.findOne(oneWayId);

        if (oneWaySchedule != null) {
            reservationDto.setOneWayScheduleDto(oneWaySchedule);

            List<ReservationDto> oneWayReservations = reservationManagerService.findByOneWayScheduleId(oneWaySchedule.getId());
            List<ReservationDto> returnReservations = reservationManagerService.findByReturnScheduleId(oneWaySchedule.getId());

            model.addAttribute("oneWaySeats", getReservedSeats(oneWayReservations, returnReservations));
            model.addAttribute("identificationTypes", IdentificationType.values());
            model.addAttribute("oneWaySchedule", oneWaySchedule);

            if (returnId.isPresent()) {
                ScheduleDto returnSchedule = scheduleManagerService.findOne(returnId.get());

                if (returnSchedule != null) {
                    reservationDto.setReturnScheduleDto(returnSchedule);

                    oneWayReservations = reservationManagerService.findByOneWayScheduleId(returnSchedule.getId());
                    returnReservations = reservationManagerService.findByReturnScheduleId(returnSchedule.getId());

                    model.addAttribute("returnSeats", getReservedSeats(oneWayReservations, returnReservations));
                    model.addAttribute("returnSchedule", returnSchedule);
                }
            }
        }

        return "site.journey.book";
    }

    @RequestMapping(value = "book/confirmation", method = RequestMethod.GET)
    public String showConfirmation(@ModelAttribute("reservation") ReservationDto reservationDto, Model model) {
        calculatePrices(reservationDto, model);

        return "site.journey.book.confirmation";
    }

    @RequestMapping(value = "book/confirm", method = RequestMethod.GET)
    public String saveReservation(@ModelAttribute("reservation") ReservationDto reservationDto, Model model,
                                  HttpSession session) {
        reservationManagerService.save(reservationDto);
        calculatePrices(reservationDto, model);

        session.removeAttribute("reservation");

        return "site.journey.book.thanks";
    }

    @RequestMapping(value = "book/sendEmail", method = RequestMethod.POST)
    public String saveReservation(@Valid @ModelAttribute("email") EmailData emailData, BindingResult bindingResult) {
        String view = "site.journey.book.thanks";

        if (!bindingResult.hasErrors()) {
            MimeMessagePreparator preparator = mimeMessage -> {

                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(emailData.getEmailAddress()));
                mimeMessage.setFrom(new InternetAddress("alsa@alsa.es"));
                mimeMessage.setText(emailData.getText());
            };

            try {
                javaMailSender.send(preparator);

                view = "site.journey.book.emailConfirmation";
            } catch (MailException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return view;
    }

    @RequestMapping(value = "book/process", method = RequestMethod.POST)
    public String saveReservation(@Valid @ModelAttribute("reservation") @Validated ReservationDto reservationDto,
                                  BindingResult bindingResult) {
        String view = "site.journey.book";

//        ReservationValidator reservationValidator = new ReservationValidator();
//        reservationValidator.validate(reservationDto, bindingResult);

        if (!bindingResult.hasErrors()) {
            view = "redirect:/journey/book/confirmation";
        }

        return view;
    }

    private void calculatePrices(ReservationDto reservationDto, Model model) {
        int seats = reservationDto.getOneWaySeats().split(", ").length;
        double seatsPrice = seats * reservationDto.getOneWayScheduleDto().getPrice();
        double totalPrice = 2.6 + seatsPrice;

        model.addAttribute("oneWaySeats", seats);
        model.addAttribute("oneWaySeatsPrice", NumberUtils.round(seatsPrice, 2));

        if (reservationDto.getReturnScheduleDto() != null) {
            seats = reservationDto.getReturnSeats().split(", ").length;
            seatsPrice = seats * reservationDto.getReturnScheduleDto().getPrice();
            totalPrice += seatsPrice;
            model.addAttribute("returnSeats", seats);
            model.addAttribute("returnSeatsPrice", NumberUtils.round(seatsPrice, 2));
        }

        if (reservationDto.isInsuranceRequested()) {
            totalPrice += 1;
        }
        if (reservationDto.isTravelingWithBike()) {
            totalPrice += 10;
        }
        if (reservationDto.isTravelingWithPet()) {
            totalPrice *= 1.5;
        }

        reservationDto.setTotalPrice(totalPrice);

        model.addAttribute("totalPrice", NumberUtils.round(totalPrice, 2));
    }

    private String getReservedSeats(List<ReservationDto> oneWayReservations,
                                    List<ReservationDto> returnReservations) {
        String seats = "";

        for (ReservationDto reservation : oneWayReservations) {
            seats += (seats.isEmpty() ? "" : ", ") + reservation.getOneWaySeats();
        }

        for (ReservationDto reservation : returnReservations) {
            seats += (seats.isEmpty() ? "" : ", ") + reservation.getReturnSeats();
        }

        return seats;
    }

    @ModelAttribute("email")
    private EmailData emailData() {
        return new EmailData();
    }

    @ModelAttribute("reservation")
    private ReservationDto bookData() {
        return new ReservationDto();
    }

}
