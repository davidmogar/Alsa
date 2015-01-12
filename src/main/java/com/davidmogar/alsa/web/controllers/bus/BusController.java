package com.davidmogar.alsa.web.controllers.bus;

import com.davidmogar.alsa.domain.bus.BusType;
import com.davidmogar.alsa.dto.bus.BusDto;
import com.davidmogar.alsa.services.bus.BusManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BusController {

    @Autowired
    private BusManagerService busManagerService;

    @RequestMapping(value = "/admin/buses/create", method = RequestMethod.GET)
    public String createUser() {
        return "admin.buses.create";
    }

    @RequestMapping(value = "/admin/buses/list", method = RequestMethod.GET)
    public ModelAndView listBuses() {
        return listBuses(1);
    }

    @RequestMapping(value = "/admin/buses/list/{pageIndex}", method = RequestMethod.GET)
    public ModelAndView listBusesPage(@PathVariable int pageIndex) {
        return listBuses(pageIndex);
    }

    @RequestMapping(value = "/admin/buses/save", method = RequestMethod.POST)
    public String saveBuses(@Valid @ModelAttribute("bus") BusDto busDto, BindingResult bindingResult) {
        String view = "admin.buses.create";

        if (!bindingResult.hasErrors()) {
            busManagerService.save(busDto);

            view = "redirect:/admin/buses/list";
        }

        return view;
    }

    @RequestMapping(value = "/api/buses", method = RequestMethod.GET)
    public
    @ResponseBody
    List<BusDto> getBuses(@RequestParam("term") String term) {
        return busManagerService.findByLicensePlateLike(term);
    }

    private ModelAndView listBuses(int pageIndex) {
        ModelAndView modelAndView = new ModelAndView("admin.buses.list");

        Page<BusDto> page = busManagerService.findAll(pageIndex);
        modelAndView.addObject("buses", page.getContent()); /* TODO: Paginate */

        return modelAndView;
    }

    @ModelAttribute("bus")
    private BusDto busDto() {
        return new BusDto();
    }

    @ModelAttribute("busTypes")
    private BusType[] busTypes() {
        return BusType.values();
    }

}
