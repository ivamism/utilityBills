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
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(unique = true, length = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "meter_type.id")
    private MeterType metertype;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owners owner;
}
