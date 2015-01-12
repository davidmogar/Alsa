package com.davidmogar.alsa.web.controllers.route;

import com.davidmogar.alsa.dto.route.RouteDto;
import com.davidmogar.alsa.services.route.PlaceManagerService;
import com.davidmogar.alsa.services.route.RouteManagerService;
import com.davidmogar.alsa.web.validation.route.RouteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RouteController {

    @Autowired
    private PlaceManagerService placeManagerService;

    @Autowired
    private RouteManagerService routeManagerService;

    @RequestMapping(value = "/admin/routes/create", method = RequestMethod.GET)
    public String createRoute() {
        return "admin.routes.create";
    }

    @RequestMapping(value = "/admin/routes/list", method = RequestMethod.GET)
    public ModelAndView listRoutes() {
        return listRoutes(1);
    }

    @RequestMapping(value = "/admin/routes/list/{pageIndex}", method = RequestMethod.GET)
    public ModelAndView listRoutesPage(@PathVariable int pageIndex) {
        return listRoutes(pageIndex);
    }

    @RequestMapping(value = "/admin/routes/save", method = RequestMethod.POST)
    public String saveNews(@Valid @ModelAttribute("route") @Validated RouteDto routeDto, BindingResult bindingResult) {
        String view = "admin.routes.create";

        RouteValidator validator = new RouteValidator(placeManagerService);
        validator.validate(routeDto, bindingResult);

        if (!bindingResult.hasErrors()) {
            routeManagerService.save(routeDto);

            view = "redirect:/admin/routes/list";
        }

        return view;
    }

    @RequestMapping(value = "/api/routes", method = RequestMethod.GET)
    public
    @ResponseBody
    List<RouteDto> getRoutes(@RequestParam("term") String term) {
        return routeManagerService.findByNameLike(term);
    }

    private ModelAndView listRoutes(int pageIndex) {
        ModelAndView modelAndView = new ModelAndView("admin.routes.list");

        Page<RouteDto> page = routeManagerService.findAll(pageIndex);
        modelAndView.addObject("routes", page.getContent()); /* TODO: Paginate */

        return modelAndView;
    }

    @ModelAttribute("route")
    private RouteDto routeDto() {
        return new RouteDto();
    }

}
