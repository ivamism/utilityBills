package com.ivam.utilityBills.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owners owner;

    private int gasAmount;
    private int gasCost;

    private int electricityAmount;
    private int electricityCost;
}
