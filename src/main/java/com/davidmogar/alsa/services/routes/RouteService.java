package com.davidmogar.alsa.services.routes;


import com.davidmogar.alsa.dto.routes.RouteDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RouteService {

    long count();

    List<RouteDto> findAll();

    Page<RouteDto> findAll(int pageIndex);

    void save(RouteDto routeDto);

}
