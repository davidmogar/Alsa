package com.davidmogar.alsa.persistence.auth;

import com.davidmogar.alsa.domain.auth.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserDataService {

    long count();

    List<User> findAll();

    Page<User> findAll(Pageable pageable);

    User findByUsername(String username);

    User save(User user);

}
