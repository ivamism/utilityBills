package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.CheckDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckDateRepository extends JpaRepository<CheckDate, Integer> {
    List<CheckDate> findAllByOrderByIdDesc();
}