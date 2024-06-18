package com.bexos.PharmacyManagementSystem.repositories;

import com.bexos.PharmacyManagementSystem.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug, Integer> {
}
