package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<Tariff, Integer> {
}