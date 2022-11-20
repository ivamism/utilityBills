package com.ivam.utilityBills.model;

import com.ivam.utilityBills.ClassPreamble;
import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@ClassPreamble(
        application = "Utility Billing Application",
        author = "@Author: Ivan Mochalov")
@Entity
@Table(name = "tariffs")

public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double value;
}
