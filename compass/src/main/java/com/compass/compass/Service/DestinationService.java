package com.compass.compass.Service;

import com.compass.compass.DTO.DestinationDto;
import com.compass.compass.ENUM.TripType;
import org.springframework.stereotype.Service;

@Service
public interface DestinationService {

    public DestinationDto findDestination(TripType tripType, String Country, String state, String city);

    public DestinationDto save(DestinationDto destinationDto);

    public DestinationDto delete(Long id);

}
