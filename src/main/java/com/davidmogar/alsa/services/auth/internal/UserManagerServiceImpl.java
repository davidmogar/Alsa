package com.davidmogar.alsa.services.auth.internal;

import com.davidmogar.alsa.domain.auth.Authority;
import com.davidmogar.alsa.domain.auth.User;
import com.davidmogar.alsa.domain.change.DatabaseChange;
import com.davidmogar.alsa.dto.auth.UserDto;
import com.davidmogar.alsa.persistence.auth.AuthorityDataService;
import com.davidmogar.alsa.persistence.auth.UserDataService;
import com.davidmogar.alsa.persistence.change.DatabaseChangeDataService;
import com.davidmogar.alsa.services.auth.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserManagerServiceImpl implements UserManagerService {

    protected static final int NUMBER_OF_USERS_PER_PAGE = 10;

    @Autowired
    private AuthorityDataService authorityDataService;

    @Autowired
    private DatabaseChangeDataService databaseChangeDataService;

    @Autowired
    private UserDataService userDataService;

    @Override
    public long count() {
        return userDataService.count();
    }

    @Override
    public List<UserDto> findAll() {
        return StreamSupport.stream(userDataService.findAll().spliterator(), false)
                .map(UserDto::new).collect(Collectors.toList());
    }

    @Override
    public Page<UserDto> findAll(int pageIndex) {
        Pageable pageable = createPageable(pageIndex);
        Page<User> page = userDataService.findAll(pageable);

        List<UserDto> users = page.getContent().stream().map(UserDto::new).collect(Collectors.toList());

        return new PageImpl<>(users, pageable, page.getTotalElements());
    }

    @Override
    public UserDto findByUsername(String username) {
        UserDto userDto = null;
        User user = userDataService.findByUsername(username);

        if (user != null) {
            userDto = new UserDto(user);
        }

        return userDto;
    }

    @Override
    public void save(UserDto userDto) {
        Authority authority = authorityDataService.findByName(userDto.getAuthority());

        userDataService.save(User.getBuilder(userDto.getUsername(), userDto.getPassword(), userDto.isEnabled())
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .authority(authority)
                .build());

        databaseChangeDataService.save(new DatabaseChange("Created user with username " + userDto.getUsername() + " and " +
                "authority " + authority.getName()));
    }

    /**
     * Creates a new Pageable object. PageIndex should be a value starting at 1.
     *
     * @param pageIndex index of the desired page.
     * @return new Pageable object.
     */
    private Pageable createPageable(int pageIndex) {
        return new PageRequest(pageIndex - 1, NUMBER_OF_USERS_PER_PAGE);
    }
}
