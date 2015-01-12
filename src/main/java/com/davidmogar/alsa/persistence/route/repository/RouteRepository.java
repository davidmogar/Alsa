package com.davidmogar.alsa.persistence.route.repository;

import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.domain.route.Route;
import com.davidmogar.alsa.persistence.route.RouteDataService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends RouteDataService, JpaRepository<Route, Long> {

    Route findByName(String name);

    List<Route> findByNameLike(String name);

    Route findByOriginAndDestination(Place origin, Place destination);

}
