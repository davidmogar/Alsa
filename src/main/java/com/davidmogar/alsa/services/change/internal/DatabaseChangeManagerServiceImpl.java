package com.davidmogar.alsa.services.change.internal;

import com.davidmogar.alsa.dto.change.DatabaseChangeDto;
import com.davidmogar.alsa.persistence.change.DatabaseChangeDataService;
import com.davidmogar.alsa.services.change.DatabaseChangeManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DatabaseChangeManagerServiceImpl implements DatabaseChangeManagerService {

    @Autowired
    private DatabaseChangeDataService databaseChangeDataService;

    @Override
    public List<DatabaseChangeDto> findRecentChanges() {
        return StreamSupport.stream(databaseChangeDataService.findFirst15ByOrderByDateDesc().spliterator(), false)
                .map(DatabaseChangeDto::new).collect(Collectors.toList());
    }

}
