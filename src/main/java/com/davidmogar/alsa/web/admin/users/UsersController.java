package com.davidmogar.alsa.web.admin.users;

import com.davidmogar.alsa.services.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser(Model model) {
        return "admin.users.create";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listUsers(Model model) {
        return listUsers(1);
    }

    @RequestMapping(value = "/list/{pageIndex}", method = RequestMethod.GET)
    public ModelAndView listUsersPage(@PathVariable int pageIndex) {
        return listUsers(pageIndex);
    }

    private ModelAndView listUsers(int pageIndex) {
        ModelAndView modelAndView = new ModelAndView("admin.users.list");

        Page page = userService.findAll(pageIndex);
        modelAndView.addObject("page", page);

        return modelAndView;
    }

}
