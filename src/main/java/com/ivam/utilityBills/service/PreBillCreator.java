package com.ivam.utilityBills.service;

import com.ivam.utilityBills.model.CheckDate;
import com.ivam.utilityBills.model.MetersData;
import com.ivam.utilityBills.repository.CheckDateRepository;
import com.ivam.utilityBills.repository.MetersDataRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString

@Service
public class PreBillCreator implements PreBillCreatorInterface {
    //TODO Think to rename class
    @Autowired
    CheckDateRepository checkDateRepository;

    @Autowired
    MetersDataRepository metersDataRepository;


    CheckDate currentCheckDate;
    CheckDate previousCheckDate;

    List<MetersData> currentMetersDataList;
    List<MetersData> previousMeterDataList;

    @Override
    public List<CheckDate> findTwoLastCheckDates() {
        return checkDateRepository.findTop2AllByOrderByVerificationDateDesc();
    }

    void setCurrentCheckDate() {
        currentCheckDate = findTwoLastCheckDates().get(0);
    }

    void setPreviousCheckDate() {
        previousCheckDate = findTwoLastCheckDates().get(1);
    }

    @Override
    public List<MetersData> getMetersDataForCheckDate(int id) {
        return metersDataRepository.findAllByCheckDates_Id(id);
    }

    public void setCurrentMetersDataList() {
        int checkDateId = currentCheckDate.getId();
        this.currentMetersDataList = getMetersDataForCheckDate(checkDateId);
    }

    public void setPreviousMeterDataList() {
        int checkDateId = previousCheckDate.getId();
        this.previousMeterDataList = getMetersDataForCheckDate(checkDateId);
    }


    public String getMeterDataName(int id) {
        String metername = currentMetersDataList.get(id).getMeter().getName();
        Date verificationDate = currentCheckDate.getVerificationDate();
        SimpleDateFormat format = new SimpleDateFormat("MM/YYYY");
        String dateForName = format.format(verificationDate);
        String name = metername + " - " + dateForName;
        return name;
    }


}


