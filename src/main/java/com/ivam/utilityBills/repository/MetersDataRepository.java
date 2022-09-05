package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.MetersData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MetersDataRepository extends JpaRepository<MetersData, Integer> {
    Set<MetersData> getByCheckDates_Id(int id);

}