package com.davidmogar.alsa.web.validation.schedule;

import com.davidmogar.alsa.dto.bus.BusDto;
import com.davidmogar.alsa.dto.route.RouteDto;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import com.davidmogar.alsa.services.bus.BusManagerService;
import com.davidmogar.alsa.services.route.RouteManagerService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ScheduleValidator implements Validator {

    /* Auto wiring doesn't work on custom validators so I'm overriding the constructor */
    private BusManagerService busManagerService;
    private RouteManagerService routeManagerService;

    public ScheduleValidator() {
    }

    public ScheduleValidator(BusManagerService busManagerService, RouteManagerService routeManagerService) {
        this.busManagerService = busManagerService;
        this.routeManagerService = routeManagerService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return ScheduleDto.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ScheduleDto schedule = (ScheduleDto) target;

        /* Get bus and route */
        BusDto busDto = busManagerService.findByLicensePlate(schedule.getBusLicense());
        RouteDto routeDto = routeManagerService.findByName(schedule.getRouteName());

        if (busDto != null) {
            schedule.setBus(busDto);
        } else {
            errors.rejectValue("busLicense", "validation.bus.notFound");
        }

        if (routeDto != null) {
            schedule.setRoute(routeDto);
        } else {
            errors.rejectValue("routeName", "validation.route.notFound");
        }
    }

}
