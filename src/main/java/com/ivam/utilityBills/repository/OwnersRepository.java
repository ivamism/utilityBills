package com.ivam.utilityBills.repository;

import com.ivam.utilityBills.model.Owners;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OwnersRepository extends JpaRepository<Owners, Integer> {

//    List<Owners> getAllByOderByIsCommonUserTrueDesk();

    List<Owners> findAllByOrderByIsCommonUserDescNameAsc();


}