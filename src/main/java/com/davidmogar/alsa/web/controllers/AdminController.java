package com.davidmogar.alsa.web.controllers;

import com.davidmogar.alsa.domain.route.Route;
import com.davidmogar.alsa.services.auth.UserService;
import com.davidmogar.alsa.services.change.DatabaseChangeService;
import com.davidmogar.alsa.services.route.PlaceService;
import com.davidmogar.alsa.services.route.RouteService;
import com.davidmogar.alsa.services.schedule.ScheduleService;
import com.davidmogar.alsa.web.listeners.ActiveSessionsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DatabaseChangeService databaseChangeService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        model.addAttribute("sessions", ActiveSessionsListener.getActiveSessions());
        model.addAttribute("activeUsers", sessionRegistry.getAllPrincipals().size());
        model.addAttribute("places", placeService.count());
        model.addAttribute("routes", routeService.count());
        model.addAttribute("schedules", scheduleService.count());
        model.addAttribute("changes", databaseChangeService.findRecentChanges());

        return "admin.home";
    }

}
