package com.davidmogar.alsa.web.controllers.routes;

import com.davidmogar.alsa.dto.routes.RouteDto;
import com.davidmogar.alsa.services.routes.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/routes")
public class RoutesController {

    @Autowired
    private RouteService routeService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createRoute(Model model) {
        return "admin.routes.create";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listRoutes() {
        return listRoutes(1);
    }

    @RequestMapping(value = "/list/{pageIndex}", method = RequestMethod.GET)
    public ModelAndView listRoutesPage(@PathVariable int pageIndex) {
        return listRoutes(pageIndex);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNews(@Valid @ModelAttribute("route") RouteDto routeDto, BindingResult bindingResult) {
        String view = "admin.routes.create";

        if (!bindingResult.hasErrors()) {
            routeService.save(routeDto);

            view = "redirect:/admin/routes/list";
        }

        return view;
    }

    private ModelAndView listRoutes(int pageIndex) {
        ModelAndView modelAndView = new ModelAndView("admin.routes.list");

        Page<RouteDto> page = routeService.findAll(pageIndex);
        modelAndView.addObject("routes", page.getContent()); /* TODO: Paginate */

        return modelAndView;
    }

    @ModelAttribute("route")
    private RouteDto routeDto() {
        return new RouteDto();
    }

}
