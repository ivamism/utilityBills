package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.Meter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterRepository extends JpaRepository<Meter, Integer> {
}