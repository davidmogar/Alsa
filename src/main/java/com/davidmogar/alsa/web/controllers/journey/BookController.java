package com.davidmogar.alsa.web.controllers.journey;

import com.davidmogar.alsa.domain.bus.IdentificationType;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import com.davidmogar.alsa.services.schedule.ScheduleService;
import com.davidmogar.alsa.web.data.BookData;
import com.davidmogar.alsa.web.data.JourneyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("journey")
public class BookController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "book/{scheduleId}", method = RequestMethod.GET)
    public String showJourneyHome(@PathVariable Long scheduleId, Model model) {
        ScheduleDto scheduleDto = scheduleService.findOne(scheduleId);

        if (scheduleDto != null) {
            model.addAttribute("identificationTypes", IdentificationType.values());
            model.addAttribute("schedule", scheduleDto);
        }

        return "site.journey.book";
    }

    @ModelAttribute("bookData")
    private BookData bookData() {
        return new BookData();
    }

}
