package com.bexos.PharmacyManagementSystem.repositories;

import com.bexos.PharmacyManagementSystem.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing Sale entities.
 */
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    /**
     * Retrieves all sales where the buyer's name contains the specified substring, ignoring case.
     *
     * @param query The substring to search for in buyer names.
     * @return A list of sales whose buyer names contain the specified substring (case insensitive).
     */
    List<Sale> findAllByBuyerContainingIgnoreCase(String query);
}
