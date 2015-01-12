package com.davidmogar.alsa.persistence.auth;

import com.davidmogar.alsa.domain.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

}
