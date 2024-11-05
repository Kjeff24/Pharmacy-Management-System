package com.bexos.PharmacyManagementSystem.services.interfaces;

import com.bexos.PharmacyManagementSystem.dtos.SaleDto;
import com.bexos.PharmacyManagementSystem.dtos.SalesResponseDto;
import com.bexos.PharmacyManagementSystem.models.Sale;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for managing sales operations in the Pharmacy Management System.
 */
@Service
public interface SaleService {
    /**
     * Records a new sale of a drug.
     *
     * @param drugId The ID of the drug being sold.
     * @param dto     DTO containing sale details.
     */
    void sellDrug(Integer drugId, SaleDto dto);

    /**
     * Retrieves a list of all sales in the system.
     *
     * @return List of SalesResponseDto objects representing each sale.
     */
    List<SalesResponseDto> findAllSales();

    /**
     * Deletes a sale record based on the provided sale ID.
     *
     * @param saleId The ID of the sale to be deleted.
     */
    void deleteBySaleId(Integer saleId);

    /**
     * Searches for sales associated with a specific buyer.
     *
     * @param query The query string to search for the buyer (e.g., name or ID).
     * @return List of SalesResponseDto objects matching the search criteria.
     */
    List<SalesResponseDto> findByBuyer(String query);
}
