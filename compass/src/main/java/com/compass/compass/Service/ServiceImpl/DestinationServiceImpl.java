package com.compass.compass.Service.ServiceImpl;

import com.compass.compass.DTO.DestinationDto;
import com.compass.compass.ENTITY.Destination;
import com.compass.compass.ENUM.TripType;
import com.compass.compass.Repository.DestinationRepository;
import com.compass.compass.Service.DestinationService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Data
@Service
public class DestinationServiceImpl implements DestinationService {

    private final ModelMapper modelMapper;

    private final DestinationRepository destinationRepository;

    public DestinationServiceImpl(ModelMapper modelMapper, DestinationRepository destinationRepository) {
        this.modelMapper = modelMapper;
        this.destinationRepository = destinationRepository;
    }


    @Override
    public DestinationDto findDestination(TripType tripType, String country, String state, String city) {
        if(tripType == TripType.Domestic) country = "India";
        Destination destination = destinationRepository.searchDestination(country, state, city);
        if (destination == null) throw new NoSuchElementException();
        return modelMapper.map(destination, DestinationDto.class);
    }

    @Override
    public DestinationDto save(DestinationDto destinationDto) {
        if(destinationDto.getTripType() == TripType.Domestic) destinationDto.setCountry("India");
        Destination destination = modelMapper.map(destinationDto, Destination.class);
        destination = destinationRepository.save(destination);
        return modelMapper.map(destination, DestinationDto.class);
    }

    @Override
    public DestinationDto delete(Long id){
        Destination destination = destinationRepository.findById(id).orElseThrow(NoSuchElementException::new);
        destinationRepository.deleteById(id);
        return modelMapper.map(destination, DestinationDto.class);
    }
}
