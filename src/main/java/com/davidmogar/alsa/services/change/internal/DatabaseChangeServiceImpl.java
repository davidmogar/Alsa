package com.davidmogar.alsa.services.change.internal;

import com.davidmogar.alsa.dto.change.DatabaseChangeDto;
import com.davidmogar.alsa.repositories.change.ChangeRepository;
import com.davidmogar.alsa.services.change.DatabaseChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DatabaseChangeServiceImpl implements DatabaseChangeService {

    @Autowired
    private ChangeRepository changeRepository;

    @Override
    public List<DatabaseChangeDto> findRecentChanges() {
        return StreamSupport.stream(changeRepository.findFirst15ByOrderByDateDesc().spliterator(), false)
                .map(DatabaseChangeDto::new).collect(Collectors.toList());
    }

}
