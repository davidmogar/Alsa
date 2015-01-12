package com.davidmogar.alsa.persistence.journey;

import com.davidmogar.alsa.domain.journey.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findByCode(String code);

    Reservation findByCodeAndIdentification(String code, String identification);

    List<Reservation> findByIdentification(String identification);

    List<Reservation> findByOneWayScheduleId(long id);

    List<Reservation> findByReturnScheduleId(long id);

}
