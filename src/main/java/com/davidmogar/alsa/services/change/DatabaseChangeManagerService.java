package com.davidmogar.alsa.services.change;

import com.davidmogar.alsa.dto.change.DatabaseChangeDto;

import java.util.List;

public interface DatabaseChangeManagerService {

    List<DatabaseChangeDto> findRecentChanges();

}
