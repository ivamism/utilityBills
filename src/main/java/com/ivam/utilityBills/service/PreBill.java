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

//    private String name;
    private int currentData;
    private int previousData;
    private  boolean status;
    private String meterType;
//    private int amount;
    private  double tariff;
//    private int cost;


    }
