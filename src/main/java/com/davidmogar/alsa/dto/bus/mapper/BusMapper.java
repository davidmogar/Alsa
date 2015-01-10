package com.davidmogar.alsa.dto.bus.mapper;

import com.davidmogar.alsa.domain.bus.Bus;
import com.davidmogar.alsa.dto.bus.BusDto;

public class BusMapper {

    public static Bus getBus(BusDto busDto) {
        return new Bus(busDto.getLicensePlate(), busDto.getLastRevision(), busDto.getType());
    }

}
