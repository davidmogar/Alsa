package com.davidmogar.alsa.services.bus.internal;

import com.davidmogar.alsa.domain.bus.Bus;
import com.davidmogar.alsa.domain.change.DatabaseChange;
import com.davidmogar.alsa.dto.bus.BusDto;
import com.davidmogar.alsa.persistence.bus.BusDataService;
import com.davidmogar.alsa.persistence.change.DatabaseChangeDataService;
import com.davidmogar.alsa.services.bus.BusManagerService;
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
public class BusManagerServiceImpl implements BusManagerService {

    protected static final int NUMBER_OF_BUSES_PER_PAGE = 10;

    @Autowired
    private DatabaseChangeDataService databaseChangeDataService;

    @Autowired
    private BusDataService busDataService;

    @Override
    public long count() {
        return busDataService.count();
    }

    @Override
    public List<BusDto> findAll() {
        return StreamSupport.stream(busDataService.findAll().spliterator(), false)
                .map(BusDto::new).collect(Collectors.toList());
    }

    @Override
    public Page<BusDto> findAll(int pageIndex) {
        Pageable pageable = createPageable(pageIndex);
        Page<Bus> page = busDataService.findAll(pageable);

        List<BusDto> users = page.getContent().stream().map(BusDto::new).collect(Collectors.toList());

        return new PageImpl<>(users, pageable, page.getTotalElements());
    }

    @Override
    public BusDto findByLicensePlate(String licensePlate) {
        BusDto busDto = null;
        Bus bus = busDataService.findByLicensePlate(licensePlate);

        if (bus != null) {
            busDto = new BusDto(bus);
        }

        return busDto;
    }

    @Override
    public List<BusDto> findByLicensePlateLike(String licensePlate) {
        return StreamSupport.stream(busDataService.findByLicensePlateLike("%" + licensePlate + "%").spliterator(), false)
                .map(BusDto::new).collect(Collectors.toList());
    }

    @Override
    public void save(BusDto busDto) {
        busDataService.save(new Bus(busDto.getLicensePlate(), busDto.getLastRevision(), busDto.getType()));

        databaseChangeDataService.save(new DatabaseChange("Created bus with license plate " + busDto.getLicensePlate()));
    }

    /**
     * Creates a new Pageable object. PageIndex should be a value starting at 1.
     *
     * @param pageIndex index of the desired page.
     * @return new Pageable object.
     */
    private Pageable createPageable(int pageIndex) {
        return new PageRequest(pageIndex - 1, NUMBER_OF_BUSES_PER_PAGE);
    }

}
