package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.CheckDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckDateRepository extends JpaRepository<CheckDate, Integer> {

    List<CheckDate> findAllByOrderByIdDesc();

    List<CheckDate> findTop2AllByOrderByVerificationDateDesc();

//    List<CheckDate> findTop2AllByOrderByVerificationDate();

//    List<CheckDate> findTop2ByVerificationDate();

//    List findByNameOrderByNameDesc(String name);


    //    CheckDate getByMaxId();
//    @Query(value = "Select max(id) from check_date cd", nativeQuery = true)
//    Integer findMaxId();





//    @Query(value = "Select min(d.count) from detail d", nativeQuery = true)
//    Integer findMinimum();

//    select * from check_date where id = (select max(id)  from check_date)

//    "select * from check_date where id = (select max(id)  from check_date)\n";

    //    select max(id) from




//    CheckDate getByMaxId();
}

