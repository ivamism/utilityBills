package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.ClassPreamble;
import com.ivam.utilityBills.model.CheckDate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@ClassPreamble(
        application = "Utility Billing Application",
        author = "@Author: Ivan Mochalov")
public interface CheckDateRepository extends JpaRepository<CheckDate, Integer> {

    List<CheckDate> findAllByOrderByIdDesc();

    List<CheckDate> findTop2AllByOrderByVerificationDateDesc();
}

