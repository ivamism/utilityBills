package com.ivam.utilityBills.model;

import lombok.*;
import org.springframework.stereotype.Service;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Service

public class PreliminaryBill {

    //    private String name;
    private int currentData;
    private int previousData;
    private boolean status;
    private String meterType;
    private int amount;
    private float tariff;
//    private int cost;

}
