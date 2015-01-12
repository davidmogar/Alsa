package com.davidmogar.alsa.services.journey;

import com.davidmogar.alsa.dto.journey.ReservationDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReservationManagerService {

    long count();

    void delete(long id);

    List<ReservationDto> findAll();

    Page<ReservationDto> findAll(int pageIndex);

    ReservationDto findByCode(String code);

    ReservationDto findByCodeAndIndentification(String code, String identification);

    List<ReservationDto> findByIndentification(String identification);

    List<ReservationDto> findByOneWayScheduleId(long id);

    List<ReservationDto> findByReturnScheduleId(long id);

    void save(ReservationDto placeDto);
    
}
