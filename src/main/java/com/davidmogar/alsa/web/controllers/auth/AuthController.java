package com.davidmogar.alsa.web.controllers.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @RequestMapping("/403")
    public String notAvailable() {
        return "site.auth.error";
    }

    @RequestMapping("/login")
    public String login(Model model, @RequestParam(required = false) Boolean success) {

        if (success != null) {
            model.addAttribute("success", success);

            if (success) {
                model.addAttribute("message", "Logout success");
            } else {
                model.addAttribute("message", "Login failure");
            }
        }

        return "site.auth.login";
    }

    @RequestMapping(value = "/denied")
    public String denied() {
        return "auth/denied";
    }

    @RequestMapping(value = "/login/failure")
    public String loginFailure() {
        return "redirect:/login?success=false";
    }

    @RequestMapping(value = "/logout/success")
    public String logoutSuccess() {
        return "redirect:/login?success=true";
    }

}
