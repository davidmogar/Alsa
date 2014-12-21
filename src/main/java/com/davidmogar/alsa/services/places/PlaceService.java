package com.davidmogar.alsa.services.places;

import com.davidmogar.alsa.dto.places.PlaceDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlaceService {

    List<PlaceDto> findAll();

    Page<PlaceDto> findAll(int pageIndex);

    void save(PlaceDto placeDto);

}
