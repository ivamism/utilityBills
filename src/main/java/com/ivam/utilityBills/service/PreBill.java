package com.ivam.utilityBills.service;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Service
public class PreBill {

    private String name;
    private int currentData;
    private int previousData;
    private  boolean status;
//    private int amount;
//    private  int tariff;
//    private int cost;

//    int amountCalculator() {
//
//        return amount= currentData-previousData;
//    }
    }
