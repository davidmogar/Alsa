package com.davidmogar.alsa.services.routes.internal;

import com.davidmogar.alsa.domain.change.DatabaseChange;
import com.davidmogar.alsa.domain.routes.Place;
import com.davidmogar.alsa.domain.routes.Route;
import com.davidmogar.alsa.dto.routes.RouteDto;
import com.davidmogar.alsa.persistence.change.DatabaseChangeRepository;
import com.davidmogar.alsa.persistence.routes.PlaceRepository;
import com.davidmogar.alsa.persistence.routes.RouteRepository;
import com.davidmogar.alsa.services.routes.RouteService;
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
public class RouteServiceImpl implements RouteService {

    protected static final int NUMBER_OF_ROUTES_PER_PAGE = 10;

    @Autowired
    private DatabaseChangeRepository databaseChangeRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public long count() {
        return routeRepository.count();
    }

    @Override
    public List<RouteDto> findAll() {
        return StreamSupport.stream(routeRepository.findAll().spliterator(), false)
                .map(RouteDto::new).collect(Collectors.toList());
    }

    @Override
    public Page<RouteDto> findAll(int pageIndex) {
        Pageable pageable = createPageable(pageIndex);
        Page<Route> page = routeRepository.findAll(pageable);

        List<RouteDto> users = page.getContent().stream().map(RouteDto::new).collect(Collectors.toList());

        return new PageImpl<>(users, pageable, page.getTotalElements());
    }

    @Override
    public void save(RouteDto routeDto) {
        Place origin = placeRepository.findOne(routeDto.getOriginPlaceId());
        Place destination = placeRepository.findOne(routeDto.getDestinationPlaceId());

        if (origin != null && destination != null) {
            routeRepository.save(Route.getBuilder(routeDto.getName(), origin, destination)
                    .description(routeDto.getDescription())
                    .distance(routeDto.getDistance())
                    .build());
        }

        databaseChangeRepository.save(new DatabaseChange("Created route with name " + routeDto.getName()));
    }

    /**
     * Creates a new Pageable object. PageIndex should be a value starting at 1.
     *
     * @param pageIndex index of the desired page.
     * @return new Pageable object.
     */
    private Pageable createPageable(int pageIndex) {
        return new PageRequest(pageIndex - 1, NUMBER_OF_ROUTES_PER_PAGE);
    }

}
