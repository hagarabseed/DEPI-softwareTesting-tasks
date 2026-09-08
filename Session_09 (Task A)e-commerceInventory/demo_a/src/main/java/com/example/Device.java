package com.example;

public abstract class Device extends Item {
    private String brand;
    private int warrantyMonths;

    public Device(String name, double price, int availableCopies, String brand, int warrantyMonths) {
        super(name, price, availableCopies);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getWarrantyMonths() { return warrantyMonths; }
    public void setWarrantyMonths(int warrantyMonths) { this.warrantyMonths = warrantyMonths; }
}