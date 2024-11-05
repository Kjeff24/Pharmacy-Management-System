package com.bexos.PharmacyManagementSystem.dtos;

import lombok.Builder;

@Builder
public record DrugDto(
        String name,
        String description,
        double price,
        int quantity,
        String supplier
) {
}
