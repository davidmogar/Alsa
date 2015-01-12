package com.davidmogar.alsa.dto.schedule.mapper;


import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.domain.schedule.Schedule;
import com.davidmogar.alsa.dto.bus.mapper.BusMapper;
import com.davidmogar.alsa.dto.route.mapper.RouteMapper;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;

public class ScheduleMapper {

    public static Schedule getSchedule(ScheduleDto scheduleDto, Place origin, Place destination) {
        return new Schedule(BusMapper.getBus(scheduleDto.getBus()),
                RouteMapper.getRoute(scheduleDto.getRoute(), origin, destination),
                scheduleDto.getDate(), scheduleDto.getHours(), scheduleDto.getPrice());
    }
}
