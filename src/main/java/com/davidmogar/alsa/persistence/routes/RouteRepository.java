package com.davidmogar.alsa.persistence.routes;

import com.davidmogar.alsa.domain.routes.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {

}
