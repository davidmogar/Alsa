package com.davidmogar.alsa.persistence.routes;

import com.davidmogar.alsa.domain.routes.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
