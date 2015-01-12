package com.davidmogar.alsa.persistence.route;

import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.domain.route.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RouteDataService {

    long count();

    void deleteAll();

    List<Route> findAll();

    Page<Route> findAll(Pageable pageable);

    Route findByName(String name);

    List<Route> findByNameLike(String name);

    Route findByOriginAndDestination(Place origin, Place destination);

    Route save(Route route);

}
