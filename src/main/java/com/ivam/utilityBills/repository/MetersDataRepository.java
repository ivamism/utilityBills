package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.MetersData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MetersDataRepository extends JpaRepository<MetersData, Integer> {

    List<MetersData> getByCheckDates_IdOrderByMeter_NameAsc(int id);

    List<MetersData> findAllByCheckDates_Id(int id);
}