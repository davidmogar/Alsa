package com.davidmogar.alsa.repositories.places;

import com.davidmogar.alsa.domain.places.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
