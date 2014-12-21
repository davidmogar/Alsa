package com.davidmogar.alsa.services.places.internal;

import com.davidmogar.alsa.domain.auth.User;
import com.davidmogar.alsa.domain.places.Place;
import com.davidmogar.alsa.dto.places.PlaceDto;
import com.davidmogar.alsa.repositories.places.PlaceRepository;
import com.davidmogar.alsa.services.places.PlaceService;
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
public class PlaceServiceImpl implements PlaceService {

    protected static final int NUMBER_OF_PLACES_PER_PAGE = 10;

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<PlaceDto> findAll() {
        return StreamSupport.stream(placeRepository.findAll().spliterator(), false)
                .map(PlaceDto::new).collect(Collectors.toList());
    }

    @Override
    public Page<PlaceDto> findAll(int pageIndex) {
        Pageable pageable = createPageable(pageIndex);
        Page<Place> page = placeRepository.findAll(pageable);

        List<PlaceDto> users = page.getContent().stream().map(PlaceDto::new).collect(Collectors.toList());

        return new PageImpl<>(users, pageable, page.getTotalElements());
    }

    @Override
    public void save(PlaceDto placeDto) {
        placeRepository.save(Place.getBuilder(placeDto.getName())
                .latitude(placeDto.getLatitude())
                .longitude(placeDto.getLongitude())
                .imagePath(placeDto.getImagePath())
                .build());
    }

    /**
     * Creates a new Pageable object. PageIndex should be a value starting at 1.
     *
     * @param pageIndex index of the desired page.
     * @return new Pageable object.
     */
    private Pageable createPageable(int pageIndex) {
        return new PageRequest(pageIndex - 1, NUMBER_OF_PLACES_PER_PAGE);
    }

}
