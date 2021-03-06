package com.davidmogar.alsa.services.schedule;

import com.davidmogar.alsa.dto.route.RouteDto;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface ScheduleManagerService {

    long count();

    List<ScheduleDto> findAll();

    Page<ScheduleDto> findAll(int pageIndex);

    List<ScheduleDto> findAll(RouteDto routeDto, Date date);

    List<ScheduleDto> findByDate(Date date);

    ScheduleDto findOne(long scheduleId);

    void save(ScheduleDto scheduleDto);

}
