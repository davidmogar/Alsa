package com.davidmogar.alsa.persistence.bus;

import com.davidmogar.alsa.domain.bus.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, String> {

}
