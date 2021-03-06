package com.davidmogar.alsa.infraestructure.populators;

import com.davidmogar.alsa.domain.auth.Authority;
import com.davidmogar.alsa.domain.auth.User;
import com.davidmogar.alsa.persistence.auth.AuthorityDataService;
import com.davidmogar.alsa.persistence.auth.UserDataService;
import com.davidmogar.alsa.persistence.auth.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AuthPopulator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthPopulator.class);

    @Autowired
    private AuthorityDataService authorityDataService;

    @Autowired
    private UserDataService userDataService;

    @PostConstruct
    private void populate() {
        Authority adminAuthority = new Authority("ROLE_ADMIN", "Access to admin area");
        Authority userAuthority = new Authority("ROLE_USER", "User of the site. Access to the user private area");

        authorityDataService.save(adminAuthority);
        authorityDataService.save(userAuthority);

        LOGGER.debug("Added authorities ROLE_ADMIN and ROLE_USER");

        userDataService.save(User.getBuilder("admin", "admin", true)
                .firstname("John")
                .lastname("Doe")
                .email("john.doe@gmail.com")
                .identification("71664722B")
                .authority(adminAuthority)
                .build());

        LOGGER.debug("Added admin user John Doe");
    }

}
