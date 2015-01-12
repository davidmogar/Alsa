package com.davidmogar.alsa.web.controllers.journey;

import com.davidmogar.alsa.domain.bus.IdentificationType;
import com.davidmogar.alsa.dto.journey.ReservationDto;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import com.davidmogar.alsa.infraestructure.utils.NumberUtils;
import com.davidmogar.alsa.services.journey.ReservationService;
import com.davidmogar.alsa.services.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("journey")
@SessionAttributes("reservation")
public class BookController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "book", method = RequestMethod.GET)
    public String showBookHome(@RequestParam Long oneWayId, @RequestParam(required = false) Optional<Long> returnId,
                               @ModelAttribute("reservation") ReservationDto reservationDto, Model model) {
        ScheduleDto oneWaySchedule = scheduleService.findOne(oneWayId);

        if (oneWaySchedule != null) {
            reservationDto.setOneWayScheduleDto(oneWaySchedule);

            List<ReservationDto> oneWayReservations = reservationService.findByOneWayScheduleId(oneWaySchedule.getId());
            List<ReservationDto> returnReservations = reservationService.findByReturnScheduleId(oneWaySchedule.getId());

            model.addAttribute("oneWaySeats", getReservedSeats(oneWayReservations, returnReservations));
            model.addAttribute("identificationTypes", IdentificationType.values());
            model.addAttribute("oneWaySchedule", oneWaySchedule);

            if (returnId.isPresent()) {
                ScheduleDto returnSchedule = scheduleService.findOne(returnId.get());

                if (returnSchedule != null) {
                    reservationDto.setReturnScheduleDto(returnSchedule);

                    oneWayReservations = reservationService.findByOneWayScheduleId(returnSchedule.getId());
                    returnReservations = reservationService.findByReturnScheduleId(returnSchedule.getId());

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
        reservationService.save(reservationDto);
        calculatePrices(reservationDto, model);

        session.removeAttribute("reservation");

        return "site.journey.book.thanks";
    }

    @RequestMapping(value = "book/process", method = RequestMethod.POST)
    public String saveReservation(@Valid @ModelAttribute("reservation") @Validated ReservationDto reservationDto,
                                  BindingResult bindingResult) {
        String view = "site.journey.book";

        if (!bindingResult.hasErrors()) {
            view = "redirect:/journey/book/confirmation";
        } else {
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

        if (reservationDto.isInsuranceRequested()) { totalPrice += 1; }
        if (reservationDto.isTravelingWithBike()) { totalPrice += 10; }
        if (reservationDto.isTravelingWithPet()) { totalPrice *= 1.5; }

        reservationDto.setTotalPrice(totalPrice);

        model.addAttribute("totalPrice", NumberUtils.round(totalPrice, 2));
    }

    private String getReservedSeats(List<ReservationDto> oneWayReservations,
            List<ReservationDto> returnReservations) {
        String seats = "";

        for (ReservationDto reservation : oneWayReservations) {
            seats += (seats.isEmpty()? "" : ", ") + reservation.getOneWaySeats();
        }

        for (ReservationDto reservation : returnReservations) {
            seats += (seats.isEmpty()? "" : ", ") + reservation.getReturnSeats();
        }

        return seats;
    }

    @ModelAttribute("reservation")
    private ReservationDto bookData() {
        return new ReservationDto();
    }

}
