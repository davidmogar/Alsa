package com.davidmogar.alsa.services.auth;

import com.davidmogar.alsa.dto.auth.AuthorityDto;

import java.util.List;

public interface AuthorityService {

    List<AuthorityDto> findAll();

    AuthorityDto findByName(String name);

    void save(AuthorityDto authorityDto);

}
