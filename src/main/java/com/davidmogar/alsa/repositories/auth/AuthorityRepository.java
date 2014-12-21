package com.davidmogar.alsa.repositories.auth;

import com.davidmogar.alsa.domain.auth.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String name);

}
