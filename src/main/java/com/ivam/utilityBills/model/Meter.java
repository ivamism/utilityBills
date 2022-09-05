package com.ivam.utilityBills.model;

import javax.persistence.*;

@Entity
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(unique = true, length = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "meter_type.id")
    private MeterType metertype;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owners owner;


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

    public Meter(int id, String name, MeterType metertype, Owners owner) {
        this.id = id;
        this.name = name;
        this.metertype = metertype;
        this.owner = owner;
    }

    public Meter(String name, MeterType metertype, Owners owner) {
        this.name = name;
        this.metertype = metertype;
        this.owner = owner;
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

    public MeterType getMetertype() {
        return metertype;
    }

    public void setMetertype(MeterType metertype) {
        this.metertype = metertype;
    }

    public Owners getOwner() {
        return owner;
    }

    public void setOwner(Owners owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Meter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", metertype=" + metertype +
                ", owner=" + owner +
                '}';
    }
}
