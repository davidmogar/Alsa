package com.davidmogar.alsa.web.controllers.schedules;

import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import com.davidmogar.alsa.services.bus.BusManagerService;
import com.davidmogar.alsa.services.route.RouteManagerService;
import com.davidmogar.alsa.services.schedule.ScheduleManagerService;
import com.davidmogar.alsa.web.validation.schedule.ScheduleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/schedules")
public class ScheduleController {

    @Autowired
    private BusManagerService busManagerService;

    @Autowired
    private RouteManagerService routeManagerService;

    @Autowired
    private ScheduleManagerService scheduleManagerService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createSchedule() {
        return "admin.schedules.create";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listSchedules() {
        return listSchedules(1);
    }

    @RequestMapping(value = "/list/{pageIndex}", method = RequestMethod.GET)
    public ModelAndView listSchedulesPage(@PathVariable int pageIndex) {
        return listSchedules(pageIndex);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNews(@Valid @ModelAttribute("schedule") @Validated ScheduleDto scheduleDto, BindingResult
            bindingResult) {
        String view = "admin.schedules.create";

        ScheduleValidator scheduleValidator = new ScheduleValidator(busManagerService, routeManagerService);
        scheduleValidator.validate(scheduleDto, bindingResult);

        if (!bindingResult.hasErrors()) {
            scheduleManagerService.save(scheduleDto);

            view = "redirect:/admin/schedules/list";
        }

        return view;
    }

    private ModelAndView listSchedules(int pageIndex) {
        ModelAndView modelAndView = new ModelAndView("admin.schedules.list");

        Page<ScheduleDto> page = scheduleManagerService.findAll(pageIndex);
        modelAndView.addObject("schedules", page.getContent()); /* TODO: Paginate */

        return modelAndView;
    }

    @ModelAttribute("schedule")
    private ScheduleDto scheduleDto() {
        return new ScheduleDto();
    }

}
