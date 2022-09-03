package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.Meter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeterRepository extends JpaRepository<Meter, Integer> {


    @Query("select m from Meter m order by m.owner.id")
    List<Meter> findAllOderByOwner_Id();



//    List<Meter> findAllOderByOwner_Name();


}