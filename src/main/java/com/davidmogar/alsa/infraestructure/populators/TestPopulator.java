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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        Route routeOneWay = Route.getBuilder("Oviedo-Donosti", origin, destination)
                .distance(400L)
                .build();

        routeRepository.deleteAll();
        routeOneWay = routeRepository.save(routeOneWay);

        LOGGER.debug("Added route Oviedo-Donosti");

        Route routeReturn = Route.getBuilder("Donosti-Oviedo", destination, origin)
                .distance(400L)
                .build();

        routeReturn = routeRepository.save(routeReturn);

        LOGGER.debug("Added route Donosti-Oviedo");

        busRepository.deleteAll();
        Bus bus = busRepository.save(new Bus("54308", new Date(), BusType.NORMAL));

        LOGGER.debug("Added bus with license plate 54308");

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2015-01-12 15:00:00");

            Schedule schedule = new Schedule();
            schedule.setRoute(routeOneWay);
            schedule.setBus(bus);
            schedule.setDate(date);
            schedule.setHours(5.5);
            schedule.setPrice(50.5);

            scheduleRepository.save(schedule);

            LOGGER.debug("Added schedule for route Oviedo-Donosti");

            schedule = new Schedule();
            schedule.setRoute(routeReturn);
            schedule.setBus(bus);
            schedule.setDate(date);
            schedule.setHours(5.5);
            schedule.setPrice(50.5);

            scheduleRepository.save(schedule);

            LOGGER.debug("Added schedule for route Donosti-Oviedo");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
