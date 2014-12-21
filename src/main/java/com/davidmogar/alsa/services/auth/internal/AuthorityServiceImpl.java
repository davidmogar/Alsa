package com.davidmogar.alsa.services.auth.internal;

import com.davidmogar.alsa.domain.auth.Authority;
import com.davidmogar.alsa.dto.auth.AuthorityDto;
import com.davidmogar.alsa.repositories.auth.AuthorityRepository;
import com.davidmogar.alsa.services.auth.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public List<AuthorityDto> findAll() {
        return StreamSupport.stream(authorityRepository.findAll().spliterator(), false)
                .map(AuthorityDto::new).collect(Collectors.toList());
    }

    @Override
    public AuthorityDto findByName(String name) {
        AuthorityDto authorityDto = null;
        Authority requestedAuthority = authorityRepository.findByName(name);

        if (requestedAuthority != null) {
            authorityDto = new AuthorityDto(requestedAuthority);
        }

        return authorityDto;
    }

    @Override
    public void save(AuthorityDto authorityDto) {
        Authority authority = new Authority(authorityDto.getName(), authorityDto.getDescription());

        authorityRepository.save(authority);
    }

}
