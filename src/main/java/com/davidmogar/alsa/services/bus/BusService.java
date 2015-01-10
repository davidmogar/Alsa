package com.davidmogar.alsa.services.bus;

import com.davidmogar.alsa.dto.bus.BusDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BusService {

    long count();

    List<BusDto> findAll();

    Page<BusDto> findAll(int pageIndex);

    void save(BusDto busDto);

}
