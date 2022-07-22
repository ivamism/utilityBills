//package com.ivam.utilityBills.model;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//public class Bill {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//
//    @ManyToOne
//    public User user;
//
//
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    Date billDate;
//
////    @OneToMany
////    @JoinColumn(name = "metersData_id")
////    List<MetersData> metersData;
//
////    @ManyToMany
////    @JoinColumn(name = "tariffs_id")
////    List<Tariffs> tariffs;
//
//
//    private int gasBill;
//    private int electricityBill;
//    private int totalSum;
//
//    public Bill() {
//    }
//
//    public Bill(int id) {
//        this.id = id;
//    }
//
//
//
//
//}
