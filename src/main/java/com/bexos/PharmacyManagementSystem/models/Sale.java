package com.bexos.PharmacyManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

/**
 * Respresent sale in the system
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sale {
    @Id
    @GeneratedValue
    private Integer id;
    private String buyer;
    private double purchasePrice;
    @Builder.Default
    private LocalDate date = LocalDate.now();
    @Builder.Default
    private LocalTime time = LocalTime.now();
    @ManyToOne
    @JoinColumn(name = "drug_id")
    @JsonBackReference
    private Drug drug;
}
