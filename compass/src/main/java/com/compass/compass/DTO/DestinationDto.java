package com.compass.compass.DTO;

import com.compass.compass.ENUM.TripType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class DestinationDto {

    private Long destinationId;

    private String city;

    private String state;

    private String country;

    @Enumerated(EnumType.STRING)
    private TripType tripType;
}
