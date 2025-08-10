package com.compass.compass.DTO;

import com.compass.compass.ENTITY.Destination;
import com.compass.compass.ENUM.TripType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Set;

@Data
public class PackageDto {

    private Long packageId;

    private String packageName;

    @Enumerated(EnumType.STRING)
    private TripType tripType;

    private String country;

    private Boolean hasState;

    private String State;

    private String duration;

    private Double price;

    private String description;

    private Set<Destination> destinations;

}

