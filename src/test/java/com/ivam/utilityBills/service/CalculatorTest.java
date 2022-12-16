package com.ivam.utilityBills.service;

import com.ivam.utilityBills.model.PreliminaryBill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CalculatorTest {

    @Autowired
    Calculator calculator;

    @Test
    void preBillListCreator() {
        calculator.setCurrentCheckDate();
        calculator.setCurrentMetersDataList();
        calculator.setPreviousCheckDate();
        calculator.setPreviousMeterDataList();
        List<PreliminaryBill> preliminaryBillList = calculator.preBillListCreator();
        assertNotNull(preliminaryBillList);
    }
    @Test
    void preBillListCreator2 () {
        calculator.setCurrentCheckDate();
        calculator.setCurrentMetersDataList();
        calculator.setPreviousCheckDate();
        calculator.setPreviousMeterDataList();
        List<PreliminaryBill> preliminaryBillList = calculator.preBillListCreator();
        int size = preliminaryBillList.size();
        int expected = 5;
        assertEquals(expected, size);
    }


    @Test
    void getCommonMeters() {
        calculator.setCurrentCheckDate();
        calculator.setCurrentMetersDataList();
        calculator.setPreviousCheckDate();
        calculator.setPreviousMeterDataList();
        List<PreliminaryBill> preliminaryBills = calculator.preBillListCreator();

        int size = calculator.commonOwnersPreBills().size();
        int expected = 2;
        assertEquals(expected, size);
    }

    @Test
    void getPrivateMeters() {
        calculator.setCurrentCheckDate();
        calculator.setCurrentMetersDataList();
        calculator.setPreviousCheckDate();
        calculator.setPreviousMeterDataList();
        List<PreliminaryBill> preliminaryBills = calculator.preBillListCreator();

        int size = calculator.privateOwnersPreBills().size();
        int expected = 3;
        assertEquals(expected, size);
    }

    @Test
    void getCommonGasAmount() {
        calculator.setCurrentCheckDate();
        calculator.setCurrentMetersDataList();
        calculator.setPreviousCheckDate();
        calculator.setPreviousMeterDataList();
        List<PreliminaryBill> preliminaryBills = calculator.preBillListCreator();

        int commonGasAmount = calculator.getCommonGasAmount();
        int expected = 500;
        assertEquals(expected, commonGasAmount);
    }

    @Test
    void getCommonElectricityAmount() {
        calculator.setCurrentCheckDate();
        calculator.setCurrentMetersDataList();
        calculator.setPreviousCheckDate();
        calculator.setPreviousMeterDataList();
        List<PreliminaryBill> preliminaryBills = calculator.preBillListCreator();

        int commonCommonElectricityAmount = calculator.getCommonElectricityAmount();
        int expected = 300;
        assertEquals(expected, commonCommonElectricityAmount);
    }

    @Test
    void privateElectricityAmountsSumCalculator() {
        calculator.setCurrentCheckDate();
        calculator.setCurrentMetersDataList();
        calculator.setPreviousCheckDate();
        calculator.setPreviousMeterDataList();
        List<PreliminaryBill> preliminaryBills = calculator.preBillListCreator();

        int sum = calculator.privateElectricityAmountsSumCalculator();
        int expected = 250;
        assertEquals(expected, sum);
    }
}