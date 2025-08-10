package com.compass.compass.Service.ServiceImpl;

import com.compass.compass.DTO.DestinationDto;
import com.compass.compass.DTO.PackageDto;
import com.compass.compass.ENTITY.Destination;
import com.compass.compass.ENTITY.Package;
import com.compass.compass.Repository.PackageRespository;
import com.compass.compass.Service.DestinationService;
import com.compass.compass.Service.PackageService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Data
public class PackageServiceImpl implements PackageService {

    private final ModelMapper modelMapper;

    private final DestinationService destinationService;

    private final PackageRespository packageRespository;

    public PackageServiceImpl(ModelMapper modelMapper, DestinationService destinationService, PackageRespository packageRespository) {
        this.modelMapper = modelMapper;
        this.destinationService = destinationService;
        this.packageRespository = packageRespository;
    }

    @Override
    public PackageDto save(PackageDto packageDto) {
        Package pack = modelMapper.map(packageDto, Package.class);
        pack.setCreationDate(LocalDateTime.now());
        Set<Destination> destinations= pack.getDestinations();
        Set<Destination> destinations1 = new HashSet<>();
        for(Destination d : destinations){
            DestinationDto destinationDto = destinationService.findDestination(d.getTripType(), d.getCountry(), d.getState(), d.getCity());
            Destination destination = modelMapper.map(destinationDto, Destination.class);
            destinations1.add(destination);
        }
        destinations.clear();
        destinations.addAll(destinations1);
        pack = packageRespository.save(pack);
        return modelMapper.map(pack, PackageDto.class);
    }

    @Override
    public PackageDto findBy(Long id) {
        Package pack = packageRespository.findById(id).orElseThrow(NoSuchElementException::new);
        return modelMapper.map(pack, PackageDto.class);
    }

    @Override
    public PackageDto Delete(Long id) {
        PackageDto packageDto = findBy(id);
        packageRespository.deleteById(id);
        if(!packageRespository.existsById(id)) return packageDto;
        return null;
    }
}
