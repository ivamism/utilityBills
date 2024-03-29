package com.ivam.utilityBills.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

// TODO think to rename  this class to, for example, MetersVerificationDate or DateOfMetersReading

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class CheckDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date verificationDate;

//TODO Check how it works if @ToString.Exclude and Fetch type is Eager
    @ToString.Exclude
    @ManyToMany(mappedBy = "checkDates", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<MetersData> metersData = new ArrayList<>();
}
