package com.davidmogar.alsa.web.controllers.journey;

import com.davidmogar.alsa.dto.journey.ReservationDto;
import com.davidmogar.alsa.services.journey.ReservationManagerService;
import com.davidmogar.alsa.web.data.TicketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("tickets")
public class TicketController {

    @Autowired
    private ReservationManagerService reservationManagerService;

    @RequestMapping(method = RequestMethod.GET)
    public String showTicketsHome() {
        return "site.tickets";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String searchTicket(@Valid @ModelAttribute TicketData ticketData, BindingResult bindingResult, Model model) {
        String view = "site.tickets";

        if (!bindingResult.hasErrors()) {
            model.addAttribute("reservation", reservationManagerService.findByCode(ticketData.getCode()));

            view = "site.tickets.info";
        }

        return view;
    }

    @RequestMapping(value = "cancel", method = RequestMethod.POST)
    public String cancelTicket(@Valid @ModelAttribute TicketData ticketData, BindingResult bindingResult, Model model) {
        String view = "site.tickets";

        if (!bindingResult.hasErrors()) {
            ReservationDto reservationDto = reservationManagerService.findByCodeAndIndentification(ticketData.getCode(),
                    ticketData.getIdentification());
            model.addAttribute("reservation", reservationDto);

            if (reservationDto != null) {
                reservationManagerService.delete(reservationDto.getId());

                view = "site.tickets.cancel";
            } else {
                view = "site.tickets.info";
            }
        }

        return view;
    }

    @ModelAttribute
    public TicketData ticketData() {
        return new TicketData();
    }

}
