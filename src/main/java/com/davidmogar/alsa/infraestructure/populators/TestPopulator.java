package com.davidmogar.alsa.infraestructure.populators;

import com.davidmogar.alsa.domain.bus.Bus;
import com.davidmogar.alsa.domain.bus.BusType;
import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.domain.route.Route;
import com.davidmogar.alsa.domain.schedule.Schedule;
import com.davidmogar.alsa.persistence.bus.BusRepository;
import com.davidmogar.alsa.persistence.route.PlaceRepository;
import com.davidmogar.alsa.persistence.route.RouteRepository;
import com.davidmogar.alsa.persistence.schedule.ScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class TestPopulator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestPopulator.class);

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

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

        placeRepository.deleteAll();
        placeRepository.save(origin);
        placeRepository.save(destination);

        LOGGER.debug("Added places Oviedo and San Sebastian");

        Route route = Route.getBuilder("Oviedo-Donosti", origin, destination)
                .distance(400L)
                .build();

        routeRepository.deleteAll();
        route = routeRepository.save(route);

        LOGGER.debug("Added route Oviedo-Donosti");

        busRepository.deleteAll();
        Bus bus = busRepository.save(new Bus("54308", new Date(), BusType.NORMAL));

        LOGGER.debug("Added bus with license plate 54308");

        Schedule schedule = new Schedule();
        schedule.setRoute(route);
        schedule.setBus(bus);
        schedule.setDate(new Date());

        scheduleRepository.save(schedule);

        LOGGER.debug("Added schedule for route Oviedo-Donosti");
    }

}
