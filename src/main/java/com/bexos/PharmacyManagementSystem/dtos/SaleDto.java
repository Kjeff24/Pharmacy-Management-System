package com.bexos.PharmacyManagementSystem.dtos;

import lombok.Builder;

@Builder
public record SaleDto(
        Integer drugId,
        String drugName,
        Integer drugQuantity,
        double drugPrice,
        int purchaseQuantity,
        String buyer
) {
}
