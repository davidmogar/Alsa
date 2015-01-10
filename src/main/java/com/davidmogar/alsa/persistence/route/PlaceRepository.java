package com.davidmogar.alsa.persistence.route;

import com.davidmogar.alsa.domain.route.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findByName(String name);

    List<Place> findByNameLike(String name);

}
