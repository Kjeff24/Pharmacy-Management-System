package com.bexos.PharmacyManagementSystem.repositories;

import com.bexos.PharmacyManagementSystem.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * DrugRepository interface for managing Drug entities.
 */
public interface DrugRepository extends JpaRepository<Drug, Integer> {
    /**
     * Retrieves all drugs whose names contain the specified substring, ignoring case.
     *
     * @param query The substring to search for in drug names.
     * @return A list of drugs whose names contain the specified substring (case-insensitive).
     */
    List<Drug> findAllByNameContainingIgnoreCase(String query);
}
