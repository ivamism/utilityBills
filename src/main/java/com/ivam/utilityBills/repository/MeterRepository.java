package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.ClassPreamble;
import com.ivam.utilityBills.model.Meter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@ClassPreamble(
        application = "Utility Billing Application",
        author = "@Author: Ivan Mochalov")
public interface MeterRepository extends JpaRepository<Meter, Integer> {
    List<Meter> findAllByOrderByNameAsc();


    List<Meter> findAllByOrderByOwnerAsc();
}