package com.ivam.utilityBills.service;

import com.ivam.utilityBills.model.CheckDate;
import com.ivam.utilityBills.model.MetersData;
import com.ivam.utilityBills.repository.CheckDateRepository;
import com.ivam.utilityBills.repository.MetersDataRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter

@Service
public class PreBillCreator implements PreBillCreatorInterface {
//TODO Think to rename class
    @Autowired
    CheckDateRepository checkDateRepository;

    @Autowired
    MetersDataRepository metersDataRepository;


    CheckDate currentCheckDate;
    CheckDate previousCheckDate;

    List<MetersData> currentMeterrsData;
    List<MetersData> previousMeterrsData;

    @Override
    public List<CheckDate> findTwoLastCheckDates() {
        List<CheckDate> twoLastCheckDates = checkDateRepository.findTop2AllByOrderByVerificationDateDesc();
        return twoLastCheckDates;
    }
    public void  getCurrentAndPreviousCheckDates(){
        CheckDate last = findTwoLastCheckDates().get(0);
        CheckDate previous = findTwoLastCheckDates().get(1);
        setCurrentCheckDate(last);
        setPreviousCheckDate(previous);


    }

    public void setCurrentCheckDate(CheckDate currentCheckDate) {
        this.currentCheckDate = currentCheckDate;
    }

    public void setPreviousCheckDate(CheckDate previousCheckDate) {
        this.previousCheckDate = previousCheckDate;
    }

    //    public void setCurrentCheckDate() {
//
//        CheckDate checkDate = findTwoLastCheckDates().get(0);
//        this.currentCheckDate = checkDate;
//    }


//
//    public void setCurrentMeterrsData() {
//        List<MetersData> metersDataList = metersDataRepository.getByCheckDates_Id(currentCheckDate.getId());
//        this.currentMeterrsData = currentMeterrsData;
//    }
//
//    public void setPreviousMeterrsData() {
//        List<MetersData> metersDataList = metersDataRepository.getByCheckDates_Id(previousCheckDate.getId());
//        this.previousMeterrsData = previousMeterrsData;
//    }

//        MetersData meterData = metersDataRepository.findById(id).get();

//    List<PreBill> PreBillListCreator(){
//        for (int i = 0; i < currentMeterrsData.size(); i++) {
//
//        }
//
//        return null;
//    }

}


