package com.ivam.utilityBills.model;

import javax.persistence.*;

@Entity
@Table (name = "tariffs")

public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double value;


    public Tariff() {
    }

//    public Tariff(int id) {
//        this.id = id;
//    }

//    public Tariff(String name) {
//        this.name = name;
//    }

//    public Tariff(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Tariff(String name, double value) {
//        this.name = name;
//        this.value = value;
//    }

    public Tariff(int id, String name, double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
