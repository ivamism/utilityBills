package com.ivam.utilityBills.model;

public enum Ownership {
    COMMON("Общий"),
    PRIVATE("Частный");

    private final String description;

    Ownership(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
