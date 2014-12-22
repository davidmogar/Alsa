package com.davidmogar.alsa.persistence.places;

import com.davidmogar.alsa.domain.places.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
