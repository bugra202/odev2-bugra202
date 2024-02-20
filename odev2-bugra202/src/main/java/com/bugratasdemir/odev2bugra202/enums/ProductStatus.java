package com.bugratasdemir.odev2bugra202.enums;

public enum ProductStatus implements EntityEnum{
    ACTIVE("Active"),
    INVALID("Invalid"),
    PASSIVE("Passive");
    private final String text;
    ProductStatus(String text) {
        this.text = text;
    }
    public String stringValue() {
        return this.text;
    }
    public String getStringValue() {
        return this.stringValue();
    }
}
