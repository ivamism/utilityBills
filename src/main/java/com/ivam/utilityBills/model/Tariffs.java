package com.ivam.utilityBills.model;

import javax.persistence.*;
import java.util.List;

@Entity

public class Tariffs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String name;
    private double value;


    public Tariffs() {
    }

    public Tariffs(int id) {
        this.id = id;
    }

    public Tariffs(String name) {
        this.name = name;
    }

    public Tariffs(String name, double value) {
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
        return "Tariffs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
