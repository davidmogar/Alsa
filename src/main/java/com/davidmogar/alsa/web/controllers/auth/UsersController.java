package com.davidmogar.alsa.web.controllers.auth;

import com.davidmogar.alsa.dto.auth.AuthorityDto;
import com.davidmogar.alsa.dto.auth.UserDto;
import com.davidmogar.alsa.persistence.journey.repository.ReservationRepository;
import com.davidmogar.alsa.services.auth.AuthorityManagerService;
import com.davidmogar.alsa.services.auth.UserManagerService;
import com.davidmogar.alsa.services.journey.ReservationManagerService;
import com.davidmogar.alsa.web.validation.auth.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private AuthorityManagerService authorityManagerService;

    @Autowired
    private ReservationManagerService reservationManagerService;

    @Autowired
    private UserManagerService userManagerService;

    @RequestMapping(value = "/admin/users/create", method = RequestMethod.GET)
    public String createUser() {
        return "admin.users.create";
    }

    @RequestMapping(value = "/admin/users/list", method = RequestMethod.GET)
    public ModelAndView listUsers() {
        return listUsers(1);
    }

    @RequestMapping(value = "/admin/users/list/{pageIndex}", method = RequestMethod.GET)
    public ModelAndView listUsersPage(@PathVariable int pageIndex) {
        return listUsers(pageIndex);
    }

    @RequestMapping(value = "/admin/users/save", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("user") @Validated UserDto userDto, BindingResult bindingResult) {
        String view = "admin.users.create";

        UserValidator validator = new UserValidator();
        validator.validate(userDto, bindingResult);

        if (!bindingResult.hasErrors()) {
            userManagerService.save(userDto);

            view = "redirect:/admin/users/list";
        } else {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error);
            }
        }

        return view;
    }

    @RequestMapping(value = "/users/profile")
    public String showUserProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto userDto = userManagerService.findByUsername(user.getUsername());

        model.addAttribute("firstName", userDto.getFirstname());
        model.addAttribute("reservations", reservationManagerService.findByIndentification(userDto.getIdentification()));

        return "site.users.profile";
    }

    private ModelAndView listUsers(int pageIndex) {
        ModelAndView modelAndView = new ModelAndView("admin.users.list");

        Page page = userManagerService.findAll(pageIndex);
        modelAndView.addObject("page", page);

        return modelAndView;
    }

    @ModelAttribute("authorities")
    private List<AuthorityDto> authorities() {
        return authorityManagerService.findAll();
    }

    @ModelAttribute("user")
    private UserDto userDto() {
        return new UserDto();
    }

}
