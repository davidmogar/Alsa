package com.davidmogar.alsa.services.schedule;

import com.davidmogar.alsa.dto.route.RouteDto;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface ScheduleService {

    long count();

    List<ScheduleDto> findAll();

    Page<ScheduleDto> findAll(int pageIndex);

    List<ScheduleDto> findAll(RouteDto routeDto, Date date);

    List<ScheduleDto> findByDate(Date date);

    void save(ScheduleDto scheduleDto);

}
