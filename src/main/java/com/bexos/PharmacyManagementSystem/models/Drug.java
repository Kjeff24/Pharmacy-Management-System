package com.bexos.PharmacyManagementSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Drug {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String supplier;

}
