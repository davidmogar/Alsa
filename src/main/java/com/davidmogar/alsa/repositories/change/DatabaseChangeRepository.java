package com.davidmogar.alsa.repositories.change;

import com.davidmogar.alsa.domain.change.DatabaseChange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseChangeRepository extends JpaRepository<DatabaseChange, Long> {

    List<DatabaseChange> findFirst15ByOrderByDateDesc();

}
