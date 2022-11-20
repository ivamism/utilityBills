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
public class MeterType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne
    @JoinColumn(name = "tariff.id")
    private Tariff tariff;
}
