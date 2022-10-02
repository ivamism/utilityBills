package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.MetersData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface MetersDataRepository extends JpaRepository<MetersData, Integer> {

    Set<MetersData> getByCheckDates_IdOrderByMeter_IdAsc(int id);

    List<MetersData> getByCheckDates_Id(int id);

//    @Query("select m from MetersData m inner join m.checkDates checkDates where checkDates.id = ?1")
//    List<MetersData> getByCheckDates_Id(int id);

}