package com.ivam.utilityBills.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor


@Entity
public class MetersData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    //    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date checkDate;


//    @ManyToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "check_date_id")
//    private CheckDate checkDate;



    @ManyToOne
    @JoinColumn(name = "meter_id")
    private Meter meter;

    private int value;

}


