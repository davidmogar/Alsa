package com.davidmogar.alsa.persistence.schedule;

import com.davidmogar.alsa.domain.route.Route;
import com.davidmogar.alsa.domain.schedule.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ScheduleDataService {

    long count();

    List<Schedule> findAll();

    Page<Schedule> findAll(Pageable pageable);

    List<Schedule> findByDate(Date date);

    List<Schedule> findByRouteAndDateBetween(Route route, Date dateStart, Date dateEnd);

    Schedule findOne(Long scheduleId);

    Schedule save(Schedule schedule);

}
