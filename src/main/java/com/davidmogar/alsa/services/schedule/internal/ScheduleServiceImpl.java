package com.davidmogar.alsa.services.schedule.internal;

import com.davidmogar.alsa.domain.bus.Bus;
import com.davidmogar.alsa.domain.change.DatabaseChange;
import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.domain.route.Route;
import com.davidmogar.alsa.domain.schedule.Schedule;
import com.davidmogar.alsa.dto.bus.mapper.BusMapper;
import com.davidmogar.alsa.dto.route.RouteDto;
import com.davidmogar.alsa.dto.route.mapper.RouteMapper;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import com.davidmogar.alsa.persistence.change.DatabaseChangeRepository;
import com.davidmogar.alsa.persistence.route.PlaceRepository;
import com.davidmogar.alsa.persistence.route.RouteRepository;
import com.davidmogar.alsa.persistence.schedule.ScheduleRepository;
import com.davidmogar.alsa.services.route.RouteService;
import com.davidmogar.alsa.services.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    protected static final int NUMBER_OF_SCHEDULES_PER_PAGE = 10;

    @Autowired
    private DatabaseChangeRepository databaseChangeRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public long count() {
        return scheduleRepository.count();
    }

    @Override
    public List<ScheduleDto> findAll() {
        return StreamSupport.stream(scheduleRepository.findAll().spliterator(), false)
                .map(ScheduleDto::new).collect(Collectors.toList());
    }

    @Override
    public Page<ScheduleDto> findAll(int pageIndex) {
        Pageable pageable = createPageable(pageIndex);
        Page<Schedule> page = scheduleRepository.findAll(pageable);

        List<ScheduleDto> users = page.getContent().stream().map(ScheduleDto::new).collect(Collectors.toList());

        return new PageImpl<>(users, pageable, page.getTotalElements());
    }

    @Override
    public List<ScheduleDto> findAll(RouteDto routeDto, Date date) {
        List<ScheduleDto> schedules = new ArrayList<>();
        Place originPlace = placeRepository.findOne(routeDto.getOrigin().getId());
        Place destinationPlace = placeRepository.findOne(routeDto.getDestination().getId());

        if (originPlace != null && destinationPlace != null) {
            Route route = routeRepository.findByOriginAndDestination(originPlace, destinationPlace);

            if (route != null) {

                /* Get tomorrow date */
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DATE, 1);

                schedules.addAll(StreamSupport.stream(scheduleRepository.findByRouteAndDateBetween(route, date, calendar
                        .getTime()).spliterator(), false).map(ScheduleDto::new).collect(Collectors.toList()));
            }
        }

        return schedules;
    }

    @Override
    public List<ScheduleDto> findByDate(Date date) {
        return StreamSupport.stream(scheduleRepository.findByDate(date).spliterator(), false)
                .map(ScheduleDto::new).collect(Collectors.toList());
    }

    @Override
    public void save(ScheduleDto scheduleDto) {
        Place origin = placeRepository.findOne(scheduleDto.getRoute().getOrigin().getId());
        Place destination = placeRepository.findOne(scheduleDto.getRoute().getDestination().getId());

        if (origin != null && destination != null) {
            scheduleRepository.save(new Schedule(BusMapper.getBus(scheduleDto.getBus()),
                    RouteMapper.getRoute(scheduleDto.getRoute(), origin, destination),
                    scheduleDto.getDate()));
        }

        databaseChangeRepository.save(new DatabaseChange("Created schedule with date " + scheduleDto.getDate()));
    }

    /**
     * Creates a new Pageable object. PageIndex should be a value starting at 1.
     *
     * @param pageIndex index of the desired page.
     * @return new Pageable object.
     */
    private Pageable createPageable(int pageIndex) {
        return new PageRequest(pageIndex - 1, NUMBER_OF_SCHEDULES_PER_PAGE);
    }

}
