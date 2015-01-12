package com.davidmogar.alsa.persistence.change.repository;

import com.davidmogar.alsa.domain.change.DatabaseChange;
import com.davidmogar.alsa.persistence.change.DatabaseChangeDataService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseChangeRepository extends DatabaseChangeDataService, JpaRepository<DatabaseChange, Long> {

    List<DatabaseChange> findFirst15ByOrderByDateDesc();

}
