package com.bexos.PharmacyManagementSystem.services.impl;

import com.bexos.PharmacyManagementSystem.dtos.DrugDto;
import com.bexos.PharmacyManagementSystem.mappers.DrugMapper;
import com.bexos.PharmacyManagementSystem.models.Drug;
import com.bexos.PharmacyManagementSystem.repositories.DrugRepository;
import com.bexos.PharmacyManagementSystem.services.interfaces.DrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DrugServiceImpl implements DrugService {
    private final DrugRepository drugRepository;
    private final DrugMapper drugMapper;

    public void addDrug(DrugDto drug) {
        drugRepository.save(drugMapper.toDrug(drug));
        System.out.println("done");
    }

    public List<Drug> findAllDrugs() {
        return drugRepository.findAll();
    }

    public Drug findByDrugId(Integer drugId) {
        return drugRepository.findById(drugId).orElse(null);
    }

    public void updateDrug(Drug drug) {

    }
}
