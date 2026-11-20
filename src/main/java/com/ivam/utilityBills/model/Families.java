package com.ivam.utilityBills.model;

public enum Families {
    MOCHALOV("Мочаловы"),
    PLOTNIKOV("Плотниковы"),
    VALIUK("Валюк");

    private final String name;

    Families(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}