package com.ivam.utilityBills.model;

import javax.persistence.*;

@Entity
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)

    int id;

    String name;

    @ManyToOne
    @JoinColumn(name = "metes_type_id")
    private MetersType metersType;


//  Constructors
    public Meter() {
    }

    public Meter(int id) {
        this.id = id;
    }

    public Meter(String name) {
        this.name = name;
    }


//Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MetersType getMetesType() {
        return metersType;
    }

    public void setMetesType(MetersType metersType) {
        this.metersType = metersType;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
