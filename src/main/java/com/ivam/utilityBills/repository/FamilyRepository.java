package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Integer> {
}