package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.Meter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeterRepository extends JpaRepository<Meter, Integer> {
//    List<Meter> findAllOderByOwner_Id();
}