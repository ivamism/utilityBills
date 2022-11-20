package com.ivam.utilityBills.model;

import com.ivam.utilityBills.ClassPreamble;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@ClassPreamble(
        application = "Utility Billing Application",
        author = "@Author: Ivan Mochalov")

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;



    private int gasAmount;
    private int gasCost;

    private int electricityAmount;
    private int electricityCost;

}
