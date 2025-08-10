package com.compass.compass.ENTITY;

import com.compass.compass.ENUM.Status;
import com.compass.compass.ENUM.TripType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.generator.values.GeneratedValues;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Data
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long packageId;

    private String packageName;

    private String duration;

    private Double price;

    private String description;

    private LocalDateTime creationDate;

    private LocalDateTime lastEditedAt;

    private LocalDateTime deletedDate;

    @ManyToMany
    @JoinTable(
            name = "package_destination_mapping",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "destination_id")
    )
    private Set<Destination> destinations;
}