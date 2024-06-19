package com.bexos.PharmacyManagementSystem.dtos;

import lombok.Builder;

@Builder
public record UpdateDto(
        String name,
        double price,
        int quantity,
        String buyer
) {
}
