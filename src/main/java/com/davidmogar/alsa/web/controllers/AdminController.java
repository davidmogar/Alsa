package com.davidmogar.alsa.web.controllers;

import com.davidmogar.alsa.services.change.DatabaseChangeManagerService;
import com.davidmogar.alsa.services.route.PlaceManagerService;
import com.davidmogar.alsa.services.route.RouteManagerService;
import com.davidmogar.alsa.services.schedule.ScheduleManagerService;
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
    private DatabaseChangeManagerService databaseChangeManagerService;

    @Autowired
    private PlaceManagerService placeManagerService;

    @Autowired
    private RouteManagerService routeManagerService;

    @Autowired
    private ScheduleManagerService scheduleManagerService;

    @Autowired
    private SessionRegistry sessionRegistry;

    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        model.addAttribute("sessions", ActiveSessionsListener.getActiveSessions());
        model.addAttribute("activeUsers", sessionRegistry.getAllPrincipals().size());
        model.addAttribute("places", placeManagerService.count());
        model.addAttribute("routes", routeManagerService.count());
        model.addAttribute("schedules", scheduleManagerService.count());
        model.addAttribute("changes", databaseChangeManagerService.findRecentChanges());

        return "admin.home";
    }

}
