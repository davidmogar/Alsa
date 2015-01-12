package com.davidmogar.alsa.persistence.bus.repository;

import com.davidmogar.alsa.domain.bus.Bus;
import com.davidmogar.alsa.persistence.bus.BusDataService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepository extends BusDataService, JpaRepository<Bus, String> {

    Bus findByLicensePlate(String licensePlace);

    List<Bus> findByLicensePlateLike(String licensePlace);

}
