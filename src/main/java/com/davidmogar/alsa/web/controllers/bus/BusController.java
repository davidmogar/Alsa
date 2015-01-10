package com.davidmogar.alsa.web.controllers.bus;

import com.davidmogar.alsa.domain.bus.BusType;
import com.davidmogar.alsa.dto.bus.BusDto;
import com.davidmogar.alsa.dto.route.PlaceDto;
import com.davidmogar.alsa.infraestructure.utils.MultipartFileUploader;
import com.davidmogar.alsa.services.bus.BusService;
import com.davidmogar.alsa.services.route.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin/buses")
public class BusController {

    @Autowired
    private BusService busService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser() {
        return "admin.buses.create";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listBuses() {
        return listBuses(1);
    }

    @RequestMapping(value = "/list/{pageIndex}", method = RequestMethod.GET)
    public ModelAndView listBusesPage(@PathVariable int pageIndex) {
        return listBuses(pageIndex);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBuses(@Valid @ModelAttribute("bus") BusDto busDto, BindingResult bindingResult) {
        String view = "admin.buses.create";

        if (!bindingResult.hasErrors()) {
            busService.save(busDto);

            view = "redirect:/admin/buses/list";
        }

        return view;
    }

    private ModelAndView listBuses(int pageIndex) {
        ModelAndView modelAndView = new ModelAndView("admin.buses.list");

        Page<BusDto> page = busService.findAll(pageIndex);
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
