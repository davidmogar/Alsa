package com.davidmogar.alsa.web.controllers.auth;

import com.davidmogar.alsa.dto.auth.AuthorityDto;
import com.davidmogar.alsa.dto.auth.UserDto;
import com.davidmogar.alsa.services.auth.AuthorityService;
import com.davidmogar.alsa.services.auth.UserService;
import com.davidmogar.alsa.web.validation.auth.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UsersController {

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser() {
        return "admin.users.create";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listUsers() {
        return listUsers(1);
    }

    @RequestMapping(value = "/list/{pageIndex}", method = RequestMethod.GET)
    public ModelAndView listUsersPage(@PathVariable int pageIndex) {
        return listUsers(pageIndex);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNews(@Valid @ModelAttribute("user") @Validated UserDto userDto, BindingResult bindingResult) {
        String view = "admin.users.create";

        UserValidator validator = new UserValidator();
        validator.validate(userDto, bindingResult);

        if (!bindingResult.hasErrors()) {
            userService.save(userDto);

            view = "redirect:/admin/users/list";
        } else {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error);
            }
        }

        return view;
    }

    private ModelAndView listUsers(int pageIndex) {
        ModelAndView modelAndView = new ModelAndView("admin.users.list");

        Page page = userService.findAll(pageIndex);
        modelAndView.addObject("page", page);

        return modelAndView;
    }

    @ModelAttribute("authorities")
    private List<AuthorityDto> authorities() {
        return authorityService.findAll();
    }

    @ModelAttribute("user")
    private UserDto userDto() {
        return new UserDto();
    }

}
