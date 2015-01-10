package com.davidmogar.alsa.web.controllers.journey;

import com.davidmogar.alsa.dto.route.RouteDto;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import com.davidmogar.alsa.persistence.route.RouteRepository;
import com.davidmogar.alsa.services.route.PlaceService;
import com.davidmogar.alsa.services.route.RouteService;
import com.davidmogar.alsa.web.data.JourneyData;
import com.davidmogar.alsa.services.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("journey")
public class JourneyController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(method = RequestMethod.GET)
    public String showJourneyHome() {
        return "site.journey";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String showSchedules(@Valid @ModelAttribute("journeyData") JourneyData journeyData,
                                BindingResult bindingResult, Model model) {
        String view = "site.journey";

        if (!bindingResult.hasErrors()) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                Date date = simpleDateFormat.parse(journeyData.getDay() + " " + journeyData.getHour());

                RouteDto routeDto = routeService.findOne(journeyData.getOrigin(), journeyData.getDestination());

                if (routeDto != null) {
                    model.addAttribute("route", routeDto);
                    model.addAttribute("schedules", scheduleService.findAll(routeDto, date));
                }

                view = "site.journey.schedules";
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return view;
    }

    @ModelAttribute("journeyData")
    private JourneyData journeyData() {
        return new JourneyData();
    }

}
