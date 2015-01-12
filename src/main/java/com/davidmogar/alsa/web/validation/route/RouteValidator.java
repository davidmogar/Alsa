package com.davidmogar.alsa.web.validation.route;

import com.davidmogar.alsa.dto.route.PlaceDto;
import com.davidmogar.alsa.dto.route.RouteDto;
import com.davidmogar.alsa.services.route.PlaceManagerService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RouteValidator implements Validator {

    /* Auto wiring doesn't work on custom validators so I'm overriding the constructor */
    private PlaceManagerService placeManagerService;

    public RouteValidator() {
    }

    public RouteValidator(PlaceManagerService placeManagerService) {
        this.placeManagerService = placeManagerService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RouteDto.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RouteDto route = (RouteDto) target;

        /* Get places */
        PlaceDto origin = placeManagerService.findByName(route.getOriginName());
        PlaceDto destination = placeManagerService.findByName(route.getDestinationName());

        if (origin != null) {
            route.setOrigin(origin);
        } else {
            errors.rejectValue("originName", "validation.place.notFound");
        }

        if (destination != null) {
            route.setDestination(destination);
        } else {
            errors.rejectValue("destinationName", "validation.place.notFound");
        }
    }

}
