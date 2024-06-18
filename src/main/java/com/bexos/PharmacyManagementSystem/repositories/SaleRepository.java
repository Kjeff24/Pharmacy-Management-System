package com.bexos.PharmacyManagementSystem.repositories;

import com.bexos.PharmacyManagementSystem.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
