package com.davidmogar.alsa.web.controllers;

import com.davidmogar.alsa.services.news.NewsManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private NewsManagerService newsManagerService;

    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        model.addAttribute("news", newsManagerService.findLastFiveNews());

        return "site.home";
    }

}