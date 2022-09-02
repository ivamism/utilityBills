package com.ivam.utilityBills.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

// TODO think to rename  this class

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




    public CheckDate(Date checkDate) {
        this.verificationDate = checkDate;
    }

    public CheckDate(int id, Date checkDate) {
        this.id = id;
        this.verificationDate = checkDate;
    }

    public CheckDate(int id) {
        this.id = id;
    }
}
