package com.davidmogar.alsa.persistence.schedule;

import com.davidmogar.alsa.domain.route.Route;
import com.davidmogar.alsa.domain.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByDate(Date date);

    List<Schedule> findByRouteAndDateBetween(Route route, Date dateStart, Date dateEnd);

}
