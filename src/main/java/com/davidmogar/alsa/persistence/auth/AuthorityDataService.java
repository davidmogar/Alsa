package com.davidmogar.alsa.persistence.auth;

import com.davidmogar.alsa.domain.auth.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityDataService {

    List<Authority> findAll();

    Authority findByName(String name);

    Authority save(Authority authority);

}
