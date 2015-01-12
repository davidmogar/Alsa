package com.davidmogar.alsa.services.schedule.internal;

import com.davidmogar.alsa.domain.bus.Bus;
import com.davidmogar.alsa.domain.change.DatabaseChange;
import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.domain.route.Route;
import com.davidmogar.alsa.domain.schedule.Schedule;
import com.davidmogar.alsa.dto.route.RouteDto;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import com.davidmogar.alsa.dto.schedule.mapper.ScheduleMapper;
import com.davidmogar.alsa.persistence.bus.BusDataService;
import com.davidmogar.alsa.persistence.change.DatabaseChangeDataService;
import com.davidmogar.alsa.persistence.route.PlaceDataService;
import com.davidmogar.alsa.persistence.route.RouteDataService;
import com.davidmogar.alsa.persistence.schedule.ScheduleDataService;
import com.davidmogar.alsa.services.schedule.ScheduleManagerService;
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
public class ScheduleManagerServiceImpl implements ScheduleManagerService {

    protected static final int NUMBER_OF_SCHEDULES_PER_PAGE = 10;

    @Autowired
    private DatabaseChangeDataService databaseChangeDataService;

    @Autowired
    private BusDataService busDataService;

    @Autowired
    private PlaceDataService placeDataService;

    @Autowired
    private RouteDataService routeDataService;

    @Autowired
    private ScheduleDataService scheduleDataService;

    @Override
    public long count() {
        return scheduleDataService.count();
    }

    @Override
    public List<ScheduleDto> findAll() {
        return StreamSupport.stream(scheduleDataService.findAll().spliterator(), false)
                .map(ScheduleDto::new).collect(Collectors.toList());
    }

    @Override
    public Page<ScheduleDto> findAll(int pageIndex) {
        Pageable pageable = createPageable(pageIndex);
        Page<Schedule> page = scheduleDataService.findAll(pageable);

        List<ScheduleDto> users = page.getContent().stream().map(ScheduleDto::new).collect(Collectors.toList());

        return new PageImpl<>(users, pageable, page.getTotalElements());
    }

    @Override
    public List<ScheduleDto> findAll(RouteDto routeDto, Date date) {
        List<ScheduleDto> schedules = new ArrayList<>();
        Place originPlace = placeDataService.findOne(routeDto.getOrigin().getId());
        Place destinationPlace = placeDataService.findOne(routeDto.getDestination().getId());

        if (originPlace != null && destinationPlace != null) {
            Route route = routeDataService.findByOriginAndDestination(originPlace, destinationPlace);

            if (route != null) {

                /* Get tomorrow date */
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DATE, 1);

                schedules.addAll(StreamSupport.stream(scheduleDataService.findByRouteAndDateBetween(route, date, calendar
                        .getTime()).spliterator(), false).map(ScheduleDto::new).collect(Collectors.toList()));
            }
        }

        return schedules;
    }

    @Override
    public List<ScheduleDto> findByDate(Date date) {
        return StreamSupport.stream(scheduleDataService.findByDate(date).spliterator(), false)
                .map(ScheduleDto::new).collect(Collectors.toList());
    }

    @Override
    public ScheduleDto findOne(long scheduleId) {
        ScheduleDto scheduleDto = null;
        Schedule schedule = scheduleDataService.findOne(scheduleId);

        if (schedule != null) {
            scheduleDto = new ScheduleDto(schedule);
        }

        return scheduleDto;
    }

    @Override
    public void save(ScheduleDto scheduleDto) {
        Bus bus = busDataService.findOne(scheduleDto.getBus().getLicensePlate());

        Place origin = placeDataService.findOne(scheduleDto.getRoute().getOrigin().getId());
        Place destination = placeDataService.findOne(scheduleDto.getRoute().getDestination().getId());

        if (origin != null & destination != null) {
            Route route = routeDataService.findByOriginAndDestination(origin, destination);

            if (bus != null && route != null) {
                scheduleDataService.save(ScheduleMapper.getSchedule(scheduleDto, bus, route));

                databaseChangeDataService.save(new DatabaseChange("Created schedule with date " + scheduleDto.getDate()));
            }
        }
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
