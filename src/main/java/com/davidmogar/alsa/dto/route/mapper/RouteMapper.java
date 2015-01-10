package com.davidmogar.alsa.dto.route.mapper;

import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.domain.route.Route;
import com.davidmogar.alsa.dto.route.RouteDto;

public class RouteMapper {

    public static Route getRoute(RouteDto routeDto, Place origin, Place destination) {
        return Route.getBuilder(routeDto.getName(), origin, destination)
                .description(routeDto.getDescription())
                .distance(routeDto.getDistance())
                .build();
    }

}
