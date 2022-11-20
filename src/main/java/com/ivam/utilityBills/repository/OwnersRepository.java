package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.ClassPreamble;
import com.ivam.utilityBills.model.Owners;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
@ClassPreamble(
        application = "Utility Billing Application",
        author = "@Author: Ivan Mochalov")

public interface OwnersRepository extends JpaRepository<Owners, Integer> {

    List<Owners> findAllByOderByIsActiveUserTrueDesk();
}