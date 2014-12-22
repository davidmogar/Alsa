package com.davidmogar.alsa.services.change.internal;

import com.davidmogar.alsa.dto.change.DatabaseChangeDto;
import com.davidmogar.alsa.repositories.change.DatabaseChangeRepository;
import com.davidmogar.alsa.services.change.DatabaseChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DatabaseChangeServiceImpl implements DatabaseChangeService {

    @Autowired
    private DatabaseChangeRepository databaseChangeRepository;

    @Override
    public List<DatabaseChangeDto> findRecentChanges() {
        return StreamSupport.stream(databaseChangeRepository.findFirst15ByOrderByDateDesc().spliterator(), false)
                .map(DatabaseChangeDto::new).collect(Collectors.toList());
    }

}
