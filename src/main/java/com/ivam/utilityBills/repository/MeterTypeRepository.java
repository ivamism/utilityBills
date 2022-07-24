package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.MeterType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterTypeRepository extends JpaRepository<MeterType, Integer> {
}