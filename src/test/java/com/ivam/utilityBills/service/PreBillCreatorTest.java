package com.ivam.utilityBills.service;

import com.ivam.utilityBills.model.CheckDate;
import com.ivam.utilityBills.model.MetersData;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PreBillCreatorTest {

    @Autowired
    PreBillCreator preBillCreator = new PreBillCreator();

    @Disabled
    @Test
    void Checkdatessetter() {
        preBillCreator.setCurrentCheckDate();
        preBillCreator.setPreviousCheckDate();
    }

    @Disabled
    @Test
    void getCurrentCheckDate() {
        CheckDate currentCheckDate = preBillCreator.currentCheckDate;
        assertNotNull(currentCheckDate);
    }

    @Disabled
    @Test
    void getPreviousCheckDate() {
        CheckDate previousCheckDate = preBillCreator.previousCheckDate;
        assertNotNull(previousCheckDate);
    }

    //@Disabled
//    @Test
//    void getMeterDataName() {
//        preBillCreator.setCurrentCheckDate();
//        preBillCreator.setCurrentMetersData();
//        String meterDataName = preBillCreator.getMeterDataName();
//        String expected = "Газовый общий";
//        assertEquals(expected, meterDataName);
//    }
    @Disabled
    @Test
    void getCurrentMetersDataSet() {
//        preBillCreator.setCurrentCheckDate();
//        preBillCreator.setPreviousCheckDate();
        List<MetersData> currentMetersData = preBillCreator.getCurrentMetersDataList();

        assertNotNull(currentMetersData);
    }

    @Disabled
    @Test
    void setCurrentMetersDataList() {
        preBillCreator.setCurrentMetersDataList();
    }

    @Disabled
    @Test
    void setPreviousMeterDataList() {
        preBillCreator.setPreviousMeterDataList();
    }

    @Disabled
    @Test
    void getCurrentMetersDataList() {
        List<MetersData> current = preBillCreator.getCurrentMetersDataList();
        assertNotNull(current);
    }

    @Disabled
    @Test
    void getPreviousMetersDataSet() {
        CheckDate previous = preBillCreator.getPreviousCheckDate();
        assertNotNull(previous);
    }

//    @Test
//    void getMeterDataName() {
//        preBillCreator.setCurrentCheckDate();
//        preBillCreator.setCurrentMetersDataList();
//        String meterDataName = preBillCreator.getMeterDataName(1);
//        assertNotNull(meterDataName);
//    }
//
//    @Test
//    void getMeterDataName2() {
//        preBillCreator.setCurrentCheckDate();
//        preBillCreator.setCurrentMetersDataList();
//        String meterDataName = preBillCreator.getMeterDataName(1);
//        String expected = "Электро общий - 04/2022";
//        assertEquals(expected, meterDataName);
//    }

}