package com.davidmogar.alsa.services.auth.internal;

import com.davidmogar.alsa.domain.auth.User;
import com.davidmogar.alsa.dto.auth.UserDto;
import com.davidmogar.alsa.repositories.auth.UserRepository;
import com.davidmogar.alsa.services.auth.UserService;
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
public class UserServiceImpl implements UserService {

    protected static final int NUMBER_OF_USERS_PER_PAGE = 10;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(UserDto::new).collect(Collectors.toList());
    }

    @Override
    public Page<UserDto> findAll(int pageIndex) {
        Pageable pageable = createPageable(pageIndex);
        Page<User> page = userRepository.findAll(pageable);

        List<UserDto> users = page.getContent().stream().map(UserDto::new).collect(Collectors.toList());

        return new PageImpl<>(users, pageable, page.getTotalElements());
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
