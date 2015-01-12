package com.davidmogar.alsa.web.controllers.journey;

import com.davidmogar.alsa.domain.journey.JourneyType;
import com.davidmogar.alsa.dto.route.RouteDto;
import com.davidmogar.alsa.services.route.PlaceService;
import com.davidmogar.alsa.services.route.RouteService;
import com.davidmogar.alsa.services.schedule.ScheduleService;
import com.davidmogar.alsa.web.data.JourneyData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("journey")
public class JourneyController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private ScheduleService scheduleService;

    @InitBinder
    protected void initBinder(ServletRequestDataBinder dataBinder) {
        dataBinder.registerCustomEditor(JourneyType.class, new PropertyEditorSupport() {
            @Override
            public String getAsText() {
                if (getValue() == null)
                    return "";

                return ((JourneyType) getValue()).name();
            }

            @Override
            public void setAsText(String value) throws IllegalArgumentException {
                if (StringUtils.isBlank(value))
                    return;

                setValue(JourneyType.valueOf(value));
            }
        });
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showJourneyHome(HttpSession session) {
        session.removeAttribute("reservation");

        return "site.journey";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String showSchedules(@Valid @ModelAttribute("journeyData") JourneyData journeyData,
                                BindingResult bindingResult, Model model) {
        String view = "site.journey";

        if (!bindingResult.hasErrors()) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date date = simpleDateFormat.parse(journeyData.getDepartureDate());
                date.setTime((new Date()).getTime());

                RouteDto routeDto = routeService.findOne(journeyData.getOrigin(), journeyData.getDestination());

                if (routeDto != null) {
                    model.addAttribute("oneWayRoute", routeDto);
                    model.addAttribute("oneWaySchedules", scheduleService.findAll(routeDto, date));
                }

                if (journeyData.getJourneyType() == JourneyType.RETURN && journeyData.getReturnDate() != null) {
                    date = simpleDateFormat.parse(journeyData.getReturnDate());
                    if (new Date().after(date)) {
                        date.setTime((new Date()).getTime());
                    }

                    routeDto = routeService.findOne(journeyData.getDestination(), journeyData.getOrigin());

                    if (routeDto != null) {
                        model.addAttribute("returnRoute", routeDto);
                        model.addAttribute("returnSchedules", scheduleService.findAll(routeDto, date));
                    }
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
