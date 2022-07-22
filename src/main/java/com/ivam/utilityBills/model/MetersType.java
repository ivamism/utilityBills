package com.ivam.utilityBills.model;

import javax.persistence.*;

@Entity
public class MetersType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

   String name;
   boolean isCommon;

    @OneToOne
    @JoinColumn(name = "tariffs_id")
    private Tariffs tariffs;

//  Constructors
    public MetersType() {
    }

    public MetersType(int id) {
        this.id = id;
    }

    public MetersType(String name) {
        this.name = name;
    }

    public MetersType(int id, String name, boolean isCommon, Tariffs tariffs) {
        this.id = id;
        this.name = name;
        this.isCommon = isCommon;
        this.tariffs = tariffs;
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

    public boolean isCommon() {
        return isCommon;
    }

    public void setCommon(boolean common) {
        isCommon = common;
    }

    public Tariffs getTariffs() {
        return tariffs;
    }

    public void setTariffs(Tariffs tariffs) {
        this.tariffs = tariffs;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "isCommon = " + isCommon + ", " +
                "tariffs = " + tariffs + ")";
    }
}
