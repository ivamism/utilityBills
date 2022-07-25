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
    @JoinColumn(name = "meter_type.id")
    private MeterType metertype;

    public MeterType getMetertype() {
        return metertype;
    }

    public void setMetertype(MeterType metertype) {
        this.metertype = metertype;
    }

//  Constructors
    public Meter() {
    }

    public Meter(int id) {
        this.id = id;
    }

    public Meter(String name) {
        this.name = name;
    }

    public Meter(int id, String name, MeterType metertype) {
        this.id = id;
        this.name = name;
        this.metertype = metertype;
    }

    public Meter(String name, MeterType metertype) {
        this.name = name;
        this.metertype = metertype;
    }

    public Meter(int id, String name) {
        this.id = id;
        this.name = name;
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
        return metertype;
    }

    public void setMetesType(MeterType meterType) {
        this.metertype = meterType;
    }

}
