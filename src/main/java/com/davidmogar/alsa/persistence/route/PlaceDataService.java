package com.davidmogar.alsa.persistence.route;

import com.davidmogar.alsa.domain.route.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceDataService {

    long count();

    void deleteAll();

    List<Place> findAll();

    Page<Place> findAll(Pageable pageable);

    Place findByName(String name);

    List<Place> findByNameLike(String name);

    List<Place> findFirst3ByOrderByVisitsDesc();

    Place findOne(Long id);

    Place save(Place place);

}
