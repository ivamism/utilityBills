package com.ivam.utilityBills.model;

import javax.persistence.*;

@Entity
public class MeterType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String name;


    @OneToOne
    @JoinColumn(name = "tariff.id")
    private Tariff tariff;

    public Tariff getTariff() {
        return tariff;
    }


    //  Constructors
    public MeterType() {
    }

    public MeterType(int id) {
        this.id = id;
    }

    public MeterType(String name) {
        this.name = name;
    }

    public MeterType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MeterType(String name, Tariff tariff) {
        this.name = name;
        this.tariff = tariff;
    }

    public MeterType(int id, String name, Tariff tariff) {
        this.id = id;
        this.name = name;
        this.tariff = tariff;
    }

    // //Getters & Setters
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


    public Tariff getTariffs() {
        return tariff;
    }

    public void setTariffs(Tariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public String toString() {
        return "MetersType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tariffs=" + tariff +
                '}';
    }
}
