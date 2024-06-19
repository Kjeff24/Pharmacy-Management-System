package com.bexos.PharmacyManagementSystem.services.impl;

import com.bexos.PharmacyManagementSystem.dtos.SaleDto;
import com.bexos.PharmacyManagementSystem.dtos.SalesResponseDto;
import com.bexos.PharmacyManagementSystem.mappers.SaleMapper;
import com.bexos.PharmacyManagementSystem.models.Drug;
import com.bexos.PharmacyManagementSystem.repositories.DrugRepository;
import com.bexos.PharmacyManagementSystem.repositories.SaleRepository;
import com.bexos.PharmacyManagementSystem.services.interfaces.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the SaleService interface that manages sale operations.
 */
@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final DrugRepository drugRepository;
    private final SaleMapper saleMapper;

    /**
     * Sells a drug by updating its quantity and saving the sale information.
     *
     * @param drugId ID of the drug being sold.
     * @param dto    SaleDto containing sale details.
     */
    public void sellDrug(Integer drugId, SaleDto dto) {
        Drug drug = drugRepository.findById(drugId).orElseThrow(null);
        drug.setQuantity(drug.getQuantity() - dto.purchaseQuantity());
        drugRepository.save(drug);
        saleRepository.save(saleMapper.toSale(dto, drug));
    }

    /**
     * Retrieves all sales and maps them to SalesResponseDto.
     *
     * @return List of SalesResponseDto representing all sales.
     */
    public List<SalesResponseDto> findAllSales() {

        return saleRepository.findAll().stream() // Retrieve all sales and convert to Stream<Sale>
                .map(saleMapper::toSaleResponseDto) // Map each Sale to SalesResponseDto using saleMapper
                .collect(Collectors.toList()); // Collect mapped SalesResponseDto into a List
    }

    /**
     * Deletes a sale by its ID.
     *
     * @param saleId ID of the sale to delete.
     */
    public void deleteBySaleId(Integer saleId) {
        saleRepository.deleteById(saleId);
    }

    /**
     * Searches for sales by buyer name, ignoring case.
     *
     * @param query Buyer name to search for.
     * @return List of SalesResponseDto matching the buyer name.
     */
    public List<SalesResponseDto> findByBuyer(String query) {
        return saleRepository.findAllByBuyerContainingIgnoreCase(query).stream() // Retrieve all sales and convert to Stream<Sale>
                .map(saleMapper::toSaleResponseDto) // Map each Sale to SalesResponseDto using saleMapper
                .collect(Collectors.toList()); // Collect mapped SalesResponseDto into a List
    }
}
