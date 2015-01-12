package com.davidmogar.alsa.persistence.auth.repository;

import com.davidmogar.alsa.domain.auth.User;
import com.davidmogar.alsa.persistence.auth.UserDataService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends UserDataService, JpaRepository<User, String> {

    User findByUsername(String username);

}
