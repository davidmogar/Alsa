package com.davidmogar.alsa.services.route;

import com.davidmogar.alsa.dto.route.PlaceDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlaceService {

    long count();

    List<PlaceDto> findAll();

    Page<PlaceDto> findAll(int pageIndex);

    PlaceDto findByName(String name);

    List<PlaceDto> findByNameLike(String name);

    void save(PlaceDto placeDto);

}
