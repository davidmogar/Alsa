package com.davidmogar.alsa.services.bus.internal;

import com.davidmogar.alsa.domain.bus.Bus;
import com.davidmogar.alsa.domain.change.DatabaseChange;
import com.davidmogar.alsa.dto.bus.BusDto;
import com.davidmogar.alsa.persistence.bus.BusRepository;
import com.davidmogar.alsa.persistence.change.DatabaseChangeRepository;
import com.davidmogar.alsa.services.bus.BusService;
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
public class BusServiceImpl implements BusService {

    protected static final int NUMBER_OF_BUSES_PER_PAGE = 10;

    @Autowired
    private DatabaseChangeRepository databaseChangeRepository;

    @Autowired
    private BusRepository busRepository;

    @Override
    public long count() {
        return busRepository.count();
    }

    @Override
    public List<BusDto> findAll() {
        return StreamSupport.stream(busRepository.findAll().spliterator(), false)
                .map(BusDto::new).collect(Collectors.toList());
    }

    @Override
    public Page<BusDto> findAll(int pageIndex) {
        Pageable pageable = createPageable(pageIndex);
        Page<Bus> page = busRepository.findAll(pageable);

        List<BusDto> users = page.getContent().stream().map(BusDto::new).collect(Collectors.toList());

        return new PageImpl<>(users, pageable, page.getTotalElements());
    }

    @Override
    public void save(BusDto busDto) {
        busRepository.save(new Bus(busDto.getLicensePlate(), busDto.getLastRevision(), busDto.getType()));

        databaseChangeRepository.save(new DatabaseChange("Created bus with license plate " + busDto.getLicensePlate()));
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
