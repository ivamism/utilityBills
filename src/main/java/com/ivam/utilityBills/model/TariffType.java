package com.ivam.utilityBills.model;

public enum TariffType {
    Gas1("газ1"),
    Gas2("газ2"),
    Gas3("газ3"),
    Electricity("электричество");

    private final String value;

    TariffType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
