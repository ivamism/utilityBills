package com.ivam.utilityBills.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MetersData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDate;

    @ManyToOne
    @JoinColumn(name = "meter_id")
    private Meter meter;

    private int value;

//    Constructors

    public MetersData() {
    }

    public MetersData(int id) {
        this.id = id;
    }

    public MetersData(int id, Date checkDate, Meter meter, int value) {
        this.id = id;
        this.checkDate = checkDate;
        this.meter = meter;
        this.value = value;
    }

//    Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MetersData{" +
                "id=" + id +
                ", checkDate=" + checkDate +
                ", meter=" + meter +
                ", value=" + value +
                '}';
    }
}


