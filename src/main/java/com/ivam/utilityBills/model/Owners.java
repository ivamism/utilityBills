package com.ivam.utilityBills.model;

import com.ivam.utilityBills.ClassPreamble;
import lombok.*;
import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@ClassPreamble(
        application = "Utility Billing Application",
        author = "@Author: Ivan Mochalov")

@Entity
@Table (name = "owners")
public class Owners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    private int registeredQuantity;
    private double share;
    private boolean isCommonUser;
//    private boolean isActive;
}



