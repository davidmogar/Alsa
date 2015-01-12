package com.davidmogar.alsa.persistence.journey;

import com.davidmogar.alsa.domain.journey.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationDataService {

    long count();

    void delete(Long id);

    List<Reservation> findAll();

    Page<Reservation> findAll(Pageable pageable);

    Reservation findByCode(String code);

    Reservation findByCodeAndIdentification(String code, String identification);

    List<Reservation> findByIdentification(String identification);

    List<Reservation> findByOneWayScheduleId(long id);

    List<Reservation> findByReturnScheduleId(long id);

    Reservation save(Reservation reservation);

}
