package com.ivam.utilityBills.model;

import javax.persistence.*;

@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int familyMembersQuantity;
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
    public Family() {
    }

    public Family(String name) {
        this.name = name;
    }

    public Family(int id) {
        this.id = id;
    }

    public Family(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Family(String name, int familyMembersQuantity, int share, boolean isCommonUser, boolean isActive) {
        this.name = name;
        this.familyMembersQuantity = familyMembersQuantity;
        this.share = share;
        this.isCommonUser = isCommonUser;
        this.isActive = isActive;
    }

    public Family(int id, String name, int familyMembersQuantity, int share, boolean isCommonUser, boolean isActive) {
        this.id = id;
        this.name = name;
        this.familyMembersQuantity = familyMembersQuantity;
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

    public int getFamilyMembersQuantity() {
        return familyMembersQuantity;
    }

    public void setFamilyMembersQuantity(int familyMembersQuantity) {
        this.familyMembersQuantity = familyMembersQuantity;
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

//    public Meter getGasMeter() {
//        return gasMeter;
//    }
//
//    public void setGasMeter(Meter gasMeter) {
//        this.gasMeter = gasMeter;
//    }
//
//    public Meter getElectricityMeter() {
//        return electricityMeter;
//    }
//
//    public void setElectricityMeter(Meter electricityMeter) {
//        this.electricityMeter = electricityMeter;
//    }

}



