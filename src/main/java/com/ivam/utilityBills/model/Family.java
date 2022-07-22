package com.ivam.utilityBills.model;

import javax.persistence.*;

@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int familyMembersQuantity;
    private double share;
    private boolean isCommonUser;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "meter_id")
    Meter meter;

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

    public Family(String name, int familyMembersQuantity, double share, boolean isCommonUser, boolean isActive, Meter meter) {
        this.name = name;
        this.familyMembersQuantity = familyMembersQuantity;
        this.share = share;
        this.isCommonUser = isCommonUser;
        this.isActive = isActive;
        this.meter = meter;
    }

    public Family(int id, String name, int familyMembersQuantity, double share, boolean isCommonUser, boolean isActive, Meter meter) {
        this.id = id;
        this.name = name;
        this.familyMembersQuantity = familyMembersQuantity;
        this.share = share;
        this.isCommonUser = isCommonUser;
        this.isActive = isActive;
        this.meter = meter;
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

    public double getShare() {
        return share;
    }

    public void setShare(double share) {
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

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyMembersQuantity=" + familyMembersQuantity +
                ", share=" + share +
                ", isCommonUser=" + isCommonUser +
                ", isActive=" + isActive +
                ", meter=" + meter +
                '}';
    }
}



