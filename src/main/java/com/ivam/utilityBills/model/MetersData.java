package com.ivam.utilityBills.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MetersData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDate;


    @ManyToOne
    @JoinColumn(name = "meter_id")
    private Meter meter;
    private int value;

//    Constructors
    

}


