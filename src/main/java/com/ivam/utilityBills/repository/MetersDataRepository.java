package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.ClassPreamble;
import com.ivam.utilityBills.model.MetersData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@ClassPreamble(
        application = "Utility Billing Application",
        author = "@Author: Ivan Mochalov")
public interface MetersDataRepository extends JpaRepository<MetersData, Integer> {

    List<MetersData> getByCheckDates_IdOrderByMeter_IdAsc(int id);

    List<MetersData> findAllByCheckDates_Id(int id);
}