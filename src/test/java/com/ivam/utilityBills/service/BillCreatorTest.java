package com.ivam.utilityBills.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BillCreatorTest {
    @Autowired
    BillCreator billCreator = new BillCreator();

    @Autowired
    PreBillCreator preBillCreator = new PreBillCreator();

    @Autowired
    PreBill preBill = new PreBill();

//    @Test
//    void getPrebillList() {
//        List<PreBill> prebillList = billCreator.getPrebillList();
//        assertNotNull(prebillList);
//    }
//    @Test
//    void getPrebillList2 () {
//        List<PreBill> prebillList = billCreator.getPrebillList();
//        int size = prebillList.size();
//        int expected = 5;
//        assertEquals(expected, size);
//    }
}