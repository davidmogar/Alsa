package com.davidmogar.alsa.services.bus;

import com.davidmogar.alsa.dto.bus.BusDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BusManagerService {

    long count();

    List<BusDto> findAll();

    Page<BusDto> findAll(int pageIndex);

    BusDto findByLicensePlate(String licensePlate);

    List<BusDto> findByLicensePlateLike(String licensePlate);

    void save(BusDto busDto);

}
