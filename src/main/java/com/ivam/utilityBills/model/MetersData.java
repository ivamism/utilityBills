//package com.ivam.utilityBills.model;
//
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//public class MetersData {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date checkDate;
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
//    Bill bill;
//
//    @OneToOne
//    @JoinColumn(name = "meter_id")
//    MetesType meter;
//
//    int previousValue;
//    int currentValue;
//    int quantity;
//
//    public MetersData() {
//    }
//
//    public MetersData(int id) {
//        this.id = id;
//    }
//
//    public MetersData(int id, Date checkDate, Bill bill, MetesType meter, int previousValue, int currentValue, int quantity) {
//        this.id = id;
//        this.checkDate = checkDate;
//        this.bill = bill;
//        this.meter = meter;
//        this.previousValue = previousValue;
//        this.currentValue = currentValue;
//        this.quantity = quantity;
//    }
//
//    @Override
//    public String toString() {
//        return "MetersData{" +
//                "id=" + id +
//                ", checkDate=" + checkDate +
//                ", bill=" + bill +
//                ", meter=" + meter +
//                ", previousValue=" + previousValue +
//                ", currentValue=" + currentValue +
//                ", quantity=" + quantity +
//                '}';
//    }
//}
