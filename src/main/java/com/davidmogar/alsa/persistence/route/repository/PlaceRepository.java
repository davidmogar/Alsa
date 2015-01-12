package com.davidmogar.alsa.persistence.route.repository;

import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.persistence.route.PlaceDataService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends PlaceDataService, JpaRepository<Place, Long> {

    Place findByName(String name);

    List<Place> findByNameLike(String name);

    List<Place> findFirst3ByOrderByVisitsDesc();

}
