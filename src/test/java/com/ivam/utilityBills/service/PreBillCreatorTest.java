package com.ivam.utilityBills.service;

import com.ivam.utilityBills.model.PreBill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PreBillCreatorTest {

    @Autowired
    PreBillCreator preBillCreator = new PreBillCreator();

    @Test
    void preBillListCreator() {
        preBillCreator.setCurrentCheckDate();
        preBillCreator.setCurrentMetersDataList();
        preBillCreator.setPreviousCheckDate();
        preBillCreator.setPreviousMeterDataList();
        List<PreBill> preBillList = preBillCreator.preBillListCreator();
        assertNotNull(preBillList);
    }
    @Test
    void preBillListCreator2 () {
        preBillCreator.setCurrentCheckDate();
        preBillCreator.setCurrentMetersDataList();
        preBillCreator.setPreviousCheckDate();
        preBillCreator.setPreviousMeterDataList();
        List<PreBill> preBillList = preBillCreator.preBillListCreator();
        int size = preBillList.size();
        int expected = 5;
        assertEquals(expected, size);
    }


    @Test
    void getCommonMeters() {
        preBillCreator.setCurrentCheckDate();
        preBillCreator.setCurrentMetersDataList();
        preBillCreator.setPreviousCheckDate();
        preBillCreator.setPreviousMeterDataList();
                preBillListCreator();
                List<PreBill> common = preBillCreator.preBills
                .stream().filter(preBills -> preBills.isStatus())
                .collect(Collectors.toList());
//        preBillCreator.commonMeters

//        preBillCreator.getCommonMeters();

//        List<PreBill> commonMeters = preBillCreator.commonMeters;
//         commonMeters.size();
        int size = common.size();
        int expected = 2;
        assertEquals(expected, size);
    }

    @Test
    void getPrivateMeters() {
        preBillCreator.setCurrentCheckDate();
        preBillCreator.setCurrentMetersDataList();
        preBillCreator.setPreviousCheckDate();
        preBillCreator.setPreviousMeterDataList();
        preBillListCreator();
        List<PreBill> privateMeters = preBillCreator.preBills
                .stream().filter(preBills -> !preBills.isStatus())
                .collect(Collectors.toList());

//        List<PreBill> privateMeters = preBillCreator.privateMeters;
        int size = privateMeters.size();
        int expected = 3;
        assertEquals(expected, size);
    }

    @Test
    void getCommonGasAmount() {
        preBillCreator.setCurrentCheckDate();
        preBillCreator.setCurrentMetersDataList();
        preBillCreator.setPreviousCheckDate();
        preBillCreator.setPreviousMeterDataList();
        preBillListCreator();
        Integer common = preBillCreator.preBills
                .stream().filter(preBills -> preBills.isStatus())
                .filter(preBills -> "Газовый".equals(preBills.getMeterType()))
                .reduce(0,(x,y)-> {
                    return x + y.getAmount();
                }, (x, y)->x+y);


        int commonGasAmount = preBillCreator.getCommonGasAmount();
        int expected = 500;
        assertEquals(expected, commonGasAmount);
    }
}