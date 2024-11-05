package com.bexos.PharmacyManagementSystem.mappers;

import com.bexos.PharmacyManagementSystem.dtos.DrugDto;
import com.bexos.PharmacyManagementSystem.models.Drug;
import org.springframework.stereotype.Service;

@Service
public class DrugMapper {

    public Drug toDrug(DrugDto dto){
        return Drug.builder()
                .name(dto.name())
                .price(dto.price())
                .quantity(dto.quantity())
                .description(dto.description())
                .supplier(dto.supplier())
                .build();
    }
}
