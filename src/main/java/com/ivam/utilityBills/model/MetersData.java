package com.ivam.utilityBills.model;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "meter_id")
    private Meter meter;

    private int value;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "check_date_meters_datas",
            joinColumns = @JoinColumn(name = "meters_datas_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "check_date_null", referencedColumnName = "id"))
    private Set<CheckDate> checkDates = new LinkedHashSet<>();

}


