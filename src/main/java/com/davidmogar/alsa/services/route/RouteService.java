package com.davidmogar.alsa.services.route;


import com.davidmogar.alsa.dto.route.PlaceDto;
import com.davidmogar.alsa.dto.route.RouteDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RouteService {

    long count();

    List<RouteDto> findAll();

    Page<RouteDto> findAll(int pageIndex);

    RouteDto findOne(String origin, String destination);

    void save(RouteDto routeDto);

}
