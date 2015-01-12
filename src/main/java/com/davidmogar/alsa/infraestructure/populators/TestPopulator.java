package com.davidmogar.alsa.infraestructure.populators;

import com.davidmogar.alsa.domain.bus.Bus;
import com.davidmogar.alsa.domain.bus.BusType;
import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.domain.route.Route;
import com.davidmogar.alsa.domain.schedule.Schedule;
import com.davidmogar.alsa.persistence.bus.BusDataService;
import com.davidmogar.alsa.persistence.route.PlaceDataService;
import com.davidmogar.alsa.persistence.route.RouteDataService;
import com.davidmogar.alsa.persistence.schedule.ScheduleDataService;
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
    private BusDataService busDataService;

    @Autowired
    private PlaceDataService placeDataService;

    @Autowired
    private RouteDataService routeDataService;

    @Autowired
    private ScheduleDataService scheduleDataService;

    @PostConstruct
    private void populate() {
        Place origin = new Place();
        origin.setName("Oviedo");
        origin.setLatitude(1L);
        origin.setLongitude(2L);
        origin.setDescription("bajkl bajjklb jfsdjhga jklbaj bajkl bajkl bajjjds bajlba jbal baj");

        Place destination = new Place();
        destination.setName("San Sebastian");
        destination.setLatitude(1L);
        destination.setLongitude(2L);
        destination.setDescription("bajkl bajjklb jfsdjhga jklbaj bajkl bajkl bajjjds bajlba jbal baj");

        placeDataService.deleteAll();
        placeDataService.save(origin);
        placeDataService.save(destination);

        LOGGER.debug("Added places Oviedo and San Sebastian");

        Route routeOneWay = Route.getBuilder("Oviedo-Donosti", origin, destination)
                .distance(400L)
                .build();

        routeDataService.deleteAll();
        routeOneWay = routeDataService.save(routeOneWay);

        LOGGER.debug("Added route Oviedo-Donosti");

        Route routeReturn = Route.getBuilder("Donosti-Oviedo", destination, origin)
                .distance(400L)
                .build();

        routeReturn = routeDataService.save(routeReturn);

        LOGGER.debug("Added route Donosti-Oviedo");

        busDataService.deleteAll();
        Bus bus = busDataService.save(new Bus("54308", new Date(), BusType.NORMAL));

        LOGGER.debug("Added bus with license plate 54308");

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2015-01-12 15:00:00");

            Schedule schedule = new Schedule();
            schedule.setRoute(routeOneWay);
            schedule.setBus(bus);
            schedule.setDate(date);
            schedule.setHours(5.5);
            schedule.setPrice(50.5);

            scheduleDataService.save(schedule);

            LOGGER.debug("Added schedule for route Oviedo-Donosti");

            schedule = new Schedule();
            schedule.setRoute(routeReturn);
            schedule.setBus(bus);
            schedule.setDate(date);
            schedule.setHours(5.5);
            schedule.setPrice(50.5);

            scheduleDataService.save(schedule);

            LOGGER.debug("Added schedule for route Donosti-Oviedo");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
