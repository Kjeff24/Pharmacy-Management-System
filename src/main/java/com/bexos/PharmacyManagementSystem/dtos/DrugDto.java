package com.bexos.PharmacyManagementSystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public record DrugDto(
        String name,
        String description,
        int price,
        int quantity,
        String supplier
) {
}
