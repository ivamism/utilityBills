package com.ivam.utilityBills.model;

public enum Quotas {
    FULL(1.0),
    TWO_THIRDS(0.666),
    HALF(0.5),
    ONE_THIRD(0.333),
    QUARTER(0.25),
    ZERO(0.0);

    private final double percentage;

    Quotas(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }
}
