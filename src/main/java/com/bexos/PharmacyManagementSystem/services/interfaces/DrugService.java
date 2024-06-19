package com.bexos.PharmacyManagementSystem.services.interfaces;

import com.bexos.PharmacyManagementSystem.dtos.DrugDto;
import com.bexos.PharmacyManagementSystem.models.Drug;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for managing Drug entities.
 */
@Service
public interface DrugService {
    /**
     * Adds a new drug.
     *
     * @param drug The DTO containing drug information to be added.
     */
    void addDrug(DrugDto drug);

    /**
     * Retrieves all drugs.
     *
     * @return A list of all drugs.
     */
    List<Drug> findAllDrugs();

    /**
     * Retrieves a drug by its ID.
     *
     * @param drugId The ID of the drug to retrieve.
     * @return The drug with the specified ID, or null if not found.
     */
    Drug findByDrugId(Integer drugId);

    /**
     * Updates an existing drug.
     *
     * @param drugId The ID of the drug to update.
     * @param drug   The updated drug object.
     */
    void updateDrug(Integer drugId, Drug drug);

    /**
     * Deletes a drug by its ID.
     *
     * @param drugId The ID of the drug to delete.
     */
    void deleteDrugById(Integer drugId);

    /**
     * Searches for drugs by name.
     *
     * @param query The name or part of the name to search for.
     * @return A list of drugs whose names contain the specified query string.
     */
    List<Drug> findDrugsByName(String query);
}
