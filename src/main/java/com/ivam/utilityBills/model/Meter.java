package com.ivam.utilityBills.model;

import javax.persistence.*;

@Entity
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    int id;

    String name;

    @ManyToOne
    @JoinColumn(name = "meter_type_id")
    private MeterType meterType;


//  Constructors
    public Meter() {
    }

    public Meter(int id) {
        this.id = id;
    }

    public Meter(String name) {
        this.name = name;
    }

    public Meter(int id, String name, MeterType meterType) {
        this.id = id;
        this.name = name;
        this.meterType = meterType;
    }

    public Meter(String name, MeterType meterType) {
        this.name = name;
        this.meterType = meterType;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MeterType getMetesType() {
        return meterType;
    }

    public void setMetesType(MeterType meterType) {
        this.meterType = meterType;
    }

}
