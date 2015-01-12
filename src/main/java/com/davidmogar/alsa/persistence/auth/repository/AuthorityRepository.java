package com.davidmogar.alsa.persistence.auth.repository;

import com.davidmogar.alsa.domain.auth.Authority;
import com.davidmogar.alsa.persistence.auth.AuthorityDataService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends AuthorityDataService, JpaRepository<Authority, Long> {

    Authority findByName(String name);

}
