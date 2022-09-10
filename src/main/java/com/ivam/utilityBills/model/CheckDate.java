package com.ivam.utilityBills.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

// TODO think to rename  this class

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

    @ToString.Exclude
    @ManyToMany(mappedBy = "checkDates", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Set<MetersData> metersDatas = new LinkedHashSet<>();

//    @Override
//    public String toString() {
//        return "CheckDate{" +
//                "id=" + id +
//                ", verificationDate=" + verificationDate +
//                '}';
//    }
}
