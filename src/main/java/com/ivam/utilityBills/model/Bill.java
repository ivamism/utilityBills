//package com.ivam.utilityBills.model;
//
//import lombok.*;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//
//public class Bill {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @ManyToOne
//    @JoinColumn(name = "checking_date_id")
//    private CheckDate checkingDate;
//
//    List<MetersData> current;
//    List<MetersData> previous;
//
//
//    private String name;
//
//    private int gasAmount;
//    private int gasCost;
//
//    private int electricityAmount;
//    private int electricityCost;
//
//
//    String findMonthForName() {
//    Date date = checkingDate.getVerificationDate();
//    Calendar calendar = Calendar.getInstance();
//    calendar.setTime(date);
////    calendar.get(Calendar.MONTH);
//    String month = calendar.getDisplayName(Calendar.MONTH,
//    Calendar.LONG_STANDALONE, new Locale("ru", "RU"));
//
//    return month;
//}
//    String findYearForName(){
//    Date date = checkingDate.getVerificationDate();
//    Calendar calendar =Calendar.getInstance();
//    calendar.setTime(date);
////    calendar.get(Calendar.MONTH);
//    String year = calendar.getDisplayName(Calendar.YEAR,
//            Calendar.LONG_STANDALONE, new Locale("ru", "RU"));
//
//    return year;
//}
//
//
//    public void setName(String name) {
//
//        this.name = name;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setCheckingDate(CheckDate checkingDate) {
//        this.checkingDate = checkingDate;
//    }
//    public void setGasAmount(int gasAmount) {
//        this.gasAmount = gasAmount;
//    }
//
//    public void setGasCost(int gasCost) {
//        this.gasCost = gasCost;
//    }
//
//    public void setElectricityAmount(int electricityAmount) {
//        this.electricityAmount = electricityAmount;
//    }
//
//    public void setElectricityCost(int electricityCost) {
//        this.electricityCost = electricityCost;
//    }
//
//
//}
