package com.ivam.utilityBills.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class MetersData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date checkDate;

    @ManyToOne
    @JoinColumn(name = "meter_id")
    private Meter meter;

    private int value;


    @ManyToMany(mappedBy = "metersDatas")
//    @OrderBy("oder.verificationDate Desc")
    private List<CheckDate> checkDates = new ArrayList<>();

}


