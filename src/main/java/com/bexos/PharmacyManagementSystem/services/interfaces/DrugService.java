package com.bexos.PharmacyManagementSystem.services.interfaces;

import com.bexos.PharmacyManagementSystem.dtos.DrugDto;
import com.bexos.PharmacyManagementSystem.models.Drug;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DrugService {
    void addDrug(DrugDto drug);

    List<Drug> findAllDrugs();

    Drug findByDrugId(Integer drugId);

    void updateDrug(Drug drug);
}
