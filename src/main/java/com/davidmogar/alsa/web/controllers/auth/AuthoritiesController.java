package com.davidmogar.alsa.web.controllers.auth;

import com.davidmogar.alsa.dto.auth.AuthorityDto;
import com.davidmogar.alsa.services.auth.AuthorityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/authorities")
public class AuthoritiesController {

    @Autowired
    private AuthorityManagerService authorityManagerService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createAuthority() {
        return "admin.authorities.create";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listAuthorities(Model model) {
        model.addAttribute("authorities", authorityManagerService.findAll());

        return "admin.authorities.list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAuthority(@Valid @ModelAttribute AuthorityDto authorityDto, BindingResult bindingResult) {
        String view = "admin.authorities.create";

        if (!bindingResult.hasErrors()) {
            authorityManagerService.save(authorityDto);

            view = "redirect:/admin/authorities/list";
        }

        return view;
    }

    @ModelAttribute("authority")
    private AuthorityDto authorityDto() {
        return new AuthorityDto();
    }

}
