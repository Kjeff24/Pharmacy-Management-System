package com.bexos.PharmacyManagementSystem.dtos;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record SalesResponseDto(
        Integer id,
        String buyer,
        double purchasePrice,
        LocalDate date,
        LocalTime time,
        String drugName
) {
}
