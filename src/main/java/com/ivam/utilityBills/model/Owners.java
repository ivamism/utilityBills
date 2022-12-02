package com.ivam.utilityBills.model;

import lombok.*;
import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table (name = "owners")
public class Owners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    private int registeredQuantity;
    private float share;
    private boolean isCommonUser;
//    private boolean isActive;
}



