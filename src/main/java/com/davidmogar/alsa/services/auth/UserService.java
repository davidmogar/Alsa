package com.davidmogar.alsa.services.auth;

import com.davidmogar.alsa.domain.auth.User;
import com.davidmogar.alsa.dto.auth.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    long count();

    List<UserDto> findAll();

    Page<UserDto> findAll(int page);

    UserDto findByUsername(String username);

    void save(UserDto userDto);
}
