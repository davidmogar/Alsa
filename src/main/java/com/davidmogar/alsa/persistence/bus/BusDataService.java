package com.davidmogar.alsa.persistence.bus;

import com.davidmogar.alsa.domain.bus.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BusDataService {

    long count();

    void deleteAll();

    List<Bus> findAll();

    Page<Bus> findAll(Pageable pageable);

    Bus findByLicensePlate(String licensePlate);

    List<Bus> findByLicensePlateLike(String licensePlate);

    Bus findOne(String licensePlate);

    Bus save(Bus bus);

}
