package com.davidmogar.alsa.services.route;


import com.davidmogar.alsa.dto.route.RouteDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RouteManagerService {

    long count();

    List<RouteDto> findAll();

    Page<RouteDto> findAll(int pageIndex);

    RouteDto findByName(String name);

    List<RouteDto> findByNameLike(String name);

    RouteDto findOne(String origin, String destination);

    void save(RouteDto routeDto);

}
