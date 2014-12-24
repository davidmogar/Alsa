package com.davidmogar.alsa.services.routes;

import com.davidmogar.alsa.dto.routes.PlaceDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlaceService {

    long count();

    List<PlaceDto> findAll();

    Page<PlaceDto> findAll(int pageIndex);

    void save(PlaceDto placeDto);

}
