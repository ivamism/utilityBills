package com.ivam.utilityBills.service;

import com.ivam.utilityBills.ClassPreamble;
import com.ivam.utilityBills.model.CheckDate;
import com.ivam.utilityBills.model.MetersData;
import java.util.List;

@ClassPreamble(
        application = "Utility Billing Application",
        author = "@Author: Ivan Mochalov")

public interface PreBillCreatorInterface {

List<CheckDate> findTwoLastCheckDates();
List<MetersData> getMetersDataForCheckDate(int id);
}
