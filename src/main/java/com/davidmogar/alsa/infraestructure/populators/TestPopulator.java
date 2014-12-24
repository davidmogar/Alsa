package com.davidmogar.alsa.infraestructure.populators;

import com.davidmogar.alsa.domain.routes.Place;
import com.davidmogar.alsa.domain.routes.Route;
import com.davidmogar.alsa.persistence.routes.PlaceRepository;
import com.davidmogar.alsa.persistence.routes.RouteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestPopulator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestPopulator.class);

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private RouteRepository routeRepository;

    @PostConstruct
    private void populate() {
        Place origin = new Place();
        origin.setName("Oviedo");
        origin.setLatitude(1L);
        origin.setLongitude(2L);

        Place destination = new Place();
        destination.setName("San Sebastian");
        destination.setLatitude(1L);
        destination.setLongitude(2L);

        placeRepository.save(origin);
        placeRepository.save(destination);

        LOGGER.debug("Added places Oviedo and San Sebastian");

        routeRepository.save(Route.getBuilder("Oviedo-Donosti", origin, destination)
                .distance(400L)
                .build());

        LOGGER.debug("Added route Oviedo-Donosti");
    }

}
