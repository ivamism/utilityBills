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
    @ManyToMany
    @JoinTable(name = "check_date_meters_datas",
            joinColumns = @JoinColumn(name = "check_date_null", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "meters_datas_id", referencedColumnName = "id"))
    private Set<MetersData> metersDatas = new LinkedHashSet<>();

}
