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

/**
 * Implementation of the DrugService interface that provides CRUD operations for drugs.
 */
@Service
@RequiredArgsConstructor
public class DrugServiceImpl implements DrugService {
    private final DrugRepository drugRepository;
    private final DrugMapper drugMapper;

    /**
     * Adds a new drug to the database.
     *
     * @param drug DTO representing the drug to be added.
     */
    public void addDrug(DrugDto drug) {
        drugRepository.save(drugMapper.toDrug(drug));
    }

    /**
     * Retrieves all drugs from the database.
     *
     * @return List of all drugs in the database.
     */
    public List<Drug> findAllDrugs() {
        return drugRepository.findAll();
    }

    /**
     * Retrieves a drug by its ID from the database.
     *
     * @param drugId The ID of the drug to retrieve.
     * @return Drug object if found, otherwise null.
     */
    public Drug findByDrugId(Integer drugId) {
        return drugRepository.findById(drugId).orElse(null);
    }

    /**
     * Updates an existing drug in the database.
     *
     * @param drugId The ID of the drug to update.
     * @param drug   Updated Drug object with new information.
     */
    public void updateDrug(Integer drugId, Drug drug) {
        Optional<Drug> updateDrug = drugRepository.findById(drugId);
        if(updateDrug.isPresent()){
            updateDrug.get().setName(drug.getName());
            updateDrug.get().setPrice(drug.getPrice());
            updateDrug.get().setQuantity(drug.getQuantity());
            updateDrug.get().setSupplier(drug.getSupplier());
            updateDrug.get().setDescription(drug.getDescription());
            drugRepository.save(updateDrug.get());
        }
    }

    /**
     * Deletes a drug from the database by its ID.
     *
     * @param drugId The ID of the drug to delete.
     */
    public void deleteDrugById(Integer drugId) {
        drugRepository.deleteById(drugId);
    }

    /**
     * Searches for drugs in the database by name, ignoring case.
     *
     * @param query The search query to match against drug names.
     * @return List of drugs whose names contain the search query.
     */
    public List<Drug> findDrugsByName(String query) {
        return drugRepository.findAllByNameContainingIgnoreCase(query);
    }
}
