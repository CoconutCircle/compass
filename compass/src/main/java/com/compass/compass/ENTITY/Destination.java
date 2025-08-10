package com.compass.compass.ENTITY;

import com.compass.compass.ENUM.TripType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long destinationId;

    private String city;

    private String state;

    private String country;

    @Enumerated(EnumType.STRING)
    private TripType tripType;

    @ManyToMany(mappedBy = "destinations")
    @JsonIgnore
    private Set<Package> packages;
}
