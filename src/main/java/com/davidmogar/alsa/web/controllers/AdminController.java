package com.davidmogar.alsa.web.controllers;

import com.davidmogar.alsa.services.auth.UserService;
import com.davidmogar.alsa.services.change.DatabaseChangeService;
import com.davidmogar.alsa.services.routes.PlaceService;
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
    private SessionRegistry sessionRegistry;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        model.addAttribute("sessions", ActiveSessionsListener.getActiveSessions());
        model.addAttribute("activeUsers", sessionRegistry.getAllPrincipals().size());
        model.addAttribute("places", placeService.count());
        model.addAttribute("users", userService.count());
        model.addAttribute("changes", databaseChangeService.findRecentChanges());

        return "admin.home";
    }

}
