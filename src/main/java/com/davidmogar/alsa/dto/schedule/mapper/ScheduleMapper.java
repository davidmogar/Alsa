package com.davidmogar.alsa.dto.schedule.mapper;


import com.davidmogar.alsa.domain.bus.Bus;
import com.davidmogar.alsa.domain.route.Route;
import com.davidmogar.alsa.domain.schedule.Schedule;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;

public class ScheduleMapper {

    public static Schedule getSchedule(ScheduleDto scheduleDto, Bus bus, Route route) {
        return new Schedule(bus, route, scheduleDto.getDate(), scheduleDto.getHours(), scheduleDto.getPrice());
    }

}
