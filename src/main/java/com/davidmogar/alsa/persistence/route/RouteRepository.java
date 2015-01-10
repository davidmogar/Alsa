package com.davidmogar.alsa.persistence.route;

import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.domain.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {

    Route findByOriginAndDestination(Place origin, Place destination);

}
