package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.Tariffs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffsRepository extends JpaRepository<Tariffs, Integer> {
}