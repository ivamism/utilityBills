package com.ivam.utilityBills.model;

import javax.persistence.*;

@Entity
@Table (name = "owners")
public class Owners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int registratedQuantity;
    private int share;
    private boolean isCommonUser;
    private boolean isActive;

//    @ManyToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "meter_id", insertable = false, updatable = false)
//    Meter gasMeter;
//
//    @ManyToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "meter_id", insertable = false, updatable = false)
//    Meter electricityMeter;


    //  Constructors

    public Owners() {
    }

    public Owners(int id) {
        this.id = id;
    }

    public Owners(String name, int registratedQuantity, int share, boolean isCommonUser, boolean isActive) {
        this.name = name;
        this.registratedQuantity = registratedQuantity;
        this.share = share;
        this.isCommonUser = isCommonUser;
        this.isActive = isActive;
    }

    public Owners(int id, String name, int registratedQuantity, int share, boolean isCommonUser, boolean isActive) {
        this.id = id;
        this.name = name;
        this.registratedQuantity = registratedQuantity;
        this.share = share;
        this.isCommonUser = isCommonUser;
        this.isActive = isActive;
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

    public int getRegistratedQuantity() {
        return registratedQuantity;
    }

    public void setRegistratedQuantity(int registratedQuantity) {
        this.registratedQuantity = registratedQuantity;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public boolean isCommonUser() {
        return isCommonUser;
    }

    public void setCommonUser(boolean commonUser) {
        isCommonUser = commonUser;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Owners{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registratedQuantity=" + registratedQuantity +
                ", share=" + share +
                ", isCommonUser=" + isCommonUser +
                ", isActive=" + isActive +
                '}';
    }
}



