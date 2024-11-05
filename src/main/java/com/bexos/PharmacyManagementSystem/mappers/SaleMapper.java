package com.bexos.PharmacyManagementSystem.mappers;

import com.bexos.PharmacyManagementSystem.dtos.SaleDto;
import com.bexos.PharmacyManagementSystem.dtos.SalesResponseDto;
import com.bexos.PharmacyManagementSystem.models.Drug;
import com.bexos.PharmacyManagementSystem.models.Sale;
import org.springframework.stereotype.Service;

@Service
public class SaleMapper {

    public Sale toSale(SaleDto dto, Drug drug){
        return Sale.builder()
                .buyer(dto.buyer())
                .drug(drug)
                .purchasePrice(dto.drugPrice() * dto.purchaseQuantity())
                .build();
    }

    public SalesResponseDto toSaleResponseDto(Sale sale){
        return SalesResponseDto.builder()
                .id(sale.getId())
                .buyer(sale.getBuyer())
                .purchasePrice(sale.getPurchasePrice())
                .date(sale.getDate())
                .time(sale.getTime())
                .drugName(sale.getDrug().getName())
                .build();
    }
}
