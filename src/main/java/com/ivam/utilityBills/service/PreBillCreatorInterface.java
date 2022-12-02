package com.ivam.utilityBills.service;

import com.ivam.utilityBills.model.CheckDate;
import com.ivam.utilityBills.model.MetersData;
import java.util.List;

public interface PreBillCreatorInterface {

List<CheckDate> findTwoLastCheckDates();
List<MetersData> getMetersDataForCheckDate(int id);
}
