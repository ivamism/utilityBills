package com.ivam.utilityBills.model;

public class Family {
    int id;
    String name;
    float share;

    public Family() {
    }

    public Family(int id, String name, float share) {
        this.id = id;
        this.name = name;
        this.share = share;
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

    public float getShare() {
        return share;
    }

    public void setShare(float share) {
        this.share = share;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", share=" + share*100 +
                "%}";
    }
}
