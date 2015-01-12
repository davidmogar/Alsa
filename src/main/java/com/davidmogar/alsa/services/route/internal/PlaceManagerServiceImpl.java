package com.davidmogar.alsa.services.route.internal;

import com.davidmogar.alsa.domain.change.DatabaseChange;
import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.dto.route.PlaceDto;
import com.davidmogar.alsa.persistence.change.DatabaseChangeDataService;
import com.davidmogar.alsa.persistence.route.PlaceDataService;
import com.davidmogar.alsa.services.route.PlaceManagerService;
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
public class PlaceManagerServiceImpl implements PlaceManagerService {

    protected static final int NUMBER_OF_PLACES_PER_PAGE = 10;

    @Autowired
    private DatabaseChangeDataService databaseChangeDataService;

    @Autowired
    private PlaceDataService placeDataService;

    @Override
    public long count() {
        return placeDataService.count();
    }

    @Override
    public List<PlaceDto> findAll() {
        return StreamSupport.stream(placeDataService.findAll().spliterator(), false)
                .map(PlaceDto::new).collect(Collectors.toList());
    }

    @Override
    public Page<PlaceDto> findAll(int pageIndex) {
        Pageable pageable = createPageable(pageIndex);
        Page<Place> page = placeDataService.findAll(pageable);

        List<PlaceDto> users = page.getContent().stream().map(PlaceDto::new).collect(Collectors.toList());

        return new PageImpl<>(users, pageable, page.getTotalElements());
    }

    @Override
    public PlaceDto findByName(String name) {
        PlaceDto placeDto = null;
        Place place = placeDataService.findByName(name);

        if (place != null) {
            placeDto = new PlaceDto(place);
        }

        return placeDto;
    }

    @Override
    public List<PlaceDto> findByNameLike(String name) {
        return StreamSupport.stream(placeDataService.findByNameLike("%" + name + "%").spliterator(), false)
                .map(PlaceDto::new).collect(Collectors.toList());
    }

    @Override
    public List<PlaceDto> findTop3Places() {
        return StreamSupport.stream(placeDataService.findFirst3ByOrderByVisitsDesc().spliterator(), false)
                .map(PlaceDto::new).collect(Collectors.toList());
    }

    @Override
    public void save(PlaceDto placeDto) {
        placeDataService.save(Place.getBuilder(placeDto.getName(), placeDto.getDescription())
                .latitude(placeDto.getLatitude())
                .longitude(placeDto.getLongitude())
                .imagePath(placeDto.getImagePath())
                .visits(placeDto.getVisits())
                .build());

        databaseChangeDataService.save(new DatabaseChange("Created place with name " + placeDto.getName()));
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
