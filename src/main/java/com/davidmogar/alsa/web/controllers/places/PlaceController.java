package com.davidmogar.alsa.web.controllers.places;

import com.davidmogar.alsa.dto.places.PlaceDto;
import com.davidmogar.alsa.infraestructure.utils.MultipartFileUploader;
import com.davidmogar.alsa.services.places.PlaceService;
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
@RequestMapping("/admin/places")
public class PlaceController {

    private static final String IMAGES_STORAGE_PATH = "/resources/places/";

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser() {
        return "admin.places.create";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listPlaces() {
        return listPlaces(1);
    }

    @RequestMapping(value = "/list/{pageIndex}", method = RequestMethod.GET)
    public ModelAndView listPlacesPage(@PathVariable int pageIndex) {
        return listPlaces(pageIndex);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePlaces(@Valid @ModelAttribute("place") PlaceDto placeDto, BindingResult bindingResult,
                           @RequestParam("image") MultipartFile image, HttpServletRequest request) {
        String view = "admin.places.create";

        if (!bindingResult.hasErrors()) {
            if (!image.isEmpty()) {
                try {
                    placeDto.setImagePath(MultipartFileUploader.uploadFile(image, IMAGES_STORAGE_PATH, request));
                } catch (Exception e) {
                    return "You failed to upload " + "image" + " => " + e.getMessage();
                }
            }

            placeService.save(placeDto);

            view = "redirect:/admin/places/list";
        }

        return view;
    }

    private ModelAndView listPlaces(int pageIndex) {
        ModelAndView modelAndView = new ModelAndView("admin.places.list");

        Page<PlaceDto> page = placeService.findAll(pageIndex);
        modelAndView.addObject("places", page.getContent()); /* TODO: Paginate */

        return modelAndView;
    }

    @ModelAttribute("place")
    private PlaceDto placeDto() {
        return new PlaceDto();
    }

}
