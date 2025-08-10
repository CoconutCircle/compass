package com.compass.compass.ENTITY;

import com.compass.compass.ENUM.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;

    private LocalDateTime paymentDate;

    private String invoicePath;

    private Long invoiceNumber;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private LocalDateTime generatedDate;
}
