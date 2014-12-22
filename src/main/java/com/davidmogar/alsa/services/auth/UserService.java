package com.davidmogar.alsa.services.auth;

import com.davidmogar.alsa.dto.auth.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    long count();

    List<UserDto> findAll();

    Page<UserDto> findAll(int page);

    void save(UserDto userDto);
}
