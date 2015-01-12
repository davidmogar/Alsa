package com.davidmogar.alsa.persistence.change;

import com.davidmogar.alsa.domain.change.DatabaseChange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseChangeDataService {

    List<DatabaseChange> findFirst15ByOrderByDateDesc();

    DatabaseChange save(DatabaseChange databaseChange);

}
