package com.davidmogar.alsa.services.auth.internal;

import com.davidmogar.alsa.domain.auth.Authority;
import com.davidmogar.alsa.domain.change.DatabaseChange;
import com.davidmogar.alsa.dto.auth.AuthorityDto;
import com.davidmogar.alsa.persistence.auth.AuthorityDataService;
import com.davidmogar.alsa.persistence.change.DatabaseChangeDataService;
import com.davidmogar.alsa.services.auth.AuthorityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorityManagerServiceImpl implements AuthorityManagerService {

    @Autowired
    private AuthorityDataService authorityDataService;

    @Autowired
    private DatabaseChangeDataService databaseChangeDataService;

    @Override
    public List<AuthorityDto> findAll() {
        return StreamSupport.stream(authorityDataService.findAll().spliterator(), false)
                .map(AuthorityDto::new).collect(Collectors.toList());
    }

    @Override
    public AuthorityDto findByName(String name) {
        AuthorityDto authorityDto = null;
        Authority requestedAuthority = authorityDataService.findByName(name);

        if (requestedAuthority != null) {
            authorityDto = new AuthorityDto(requestedAuthority);
        }

        return authorityDto;
    }

    @Override
    public void save(AuthorityDto authorityDto) {
        Authority authority = new Authority(authorityDto.getName(), authorityDto.getDescription());

        authorityDataService.save(authority);

        databaseChangeDataService.save(new DatabaseChange("Created authority with name " + authority.getName()));
    }

}
