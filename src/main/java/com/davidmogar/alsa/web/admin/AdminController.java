package com.davidmogar.alsa.web.admin;

import com.davidmogar.alsa.services.auth.UserService;
import com.davidmogar.alsa.services.change.DatabaseChangeService;
import com.davidmogar.alsa.services.places.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        model.addAttribute("places", placeService.count());
        model.addAttribute("users", userService.count());
        model.addAttribute("changes", databaseChangeService.findRecentChanges());

        return "admin.home";
    }

}
