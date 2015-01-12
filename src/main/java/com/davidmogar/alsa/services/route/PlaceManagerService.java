package com.davidmogar.alsa.services.route;

import com.davidmogar.alsa.dto.route.PlaceDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlaceManagerService {

    long count();

    List<PlaceDto> findAll();

    Page<PlaceDto> findAll(int pageIndex);

    PlaceDto findByName(String name);

    List<PlaceDto> findByNameLike(String name);

    List<PlaceDto> findTop3Places();

    void save(PlaceDto placeDto);

}
