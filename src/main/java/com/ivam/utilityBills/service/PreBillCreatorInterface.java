package com.ivam.utilityBills.service;


import com.ivam.utilityBills.model.CheckDate;
import com.ivam.utilityBills.model.MetersData;

import java.util.List;


public interface PreBillCreatorInterface {

//    CheckDate getByMaxId();

//Integer getMaxId();

List<CheckDate> findTwoLastCheckDates();
List<MetersData> getMetersDataForCheckDate(int id);

}
