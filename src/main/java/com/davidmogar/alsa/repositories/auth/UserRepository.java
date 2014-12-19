package com.davidmogar.alsa.repositories.auth;

import com.davidmogar.alsa.domain.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
