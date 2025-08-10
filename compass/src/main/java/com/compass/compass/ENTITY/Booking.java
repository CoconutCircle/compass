package com.compass.compass.ENTITY;

import com.compass.compass.ENUM.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;

    private LocalDateTime travelDate;

    private Double amount;

    @Enumerated(EnumType.STRING )
    private Status status;

    private String action;
}
