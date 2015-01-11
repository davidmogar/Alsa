package com.davidmogar.alsa.web.controllers.journey;

import com.davidmogar.alsa.domain.bus.IdentificationType;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import com.davidmogar.alsa.services.schedule.ScheduleService;
import com.davidmogar.alsa.web.data.BookData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("journey")
public class BookController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "book", method = RequestMethod.GET)
    public String showJourneyHome(@RequestParam Long oneWayId, @RequestParam(required = false) Optional<Long> returnId,
                                  Model model) {
        ScheduleDto oneWaySchedule = scheduleService.findOne(oneWayId);
        if (oneWaySchedule != null) {
            model.addAttribute("identificationTypes", IdentificationType.values());
            model.addAttribute("oneWaySchedule", oneWaySchedule);

            if (returnId.isPresent()) {
                ScheduleDto returnSchedule = scheduleService.findOne(returnId.get());
                if (returnSchedule != null) {
                    model.addAttribute("returnSchedule", returnSchedule);
                }
            }
        }

        return "site.journey.book";
    }

    @ModelAttribute("bookData")
    private BookData bookData() {
        return new BookData();
    }

}
