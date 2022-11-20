package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.ClassPreamble;
import com.ivam.utilityBills.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

@ClassPreamble(
        application = "Utility Billing Application",
        author = "@Author: Ivan Mochalov")

public interface TariffRepository extends JpaRepository<Tariff, Integer> {
}