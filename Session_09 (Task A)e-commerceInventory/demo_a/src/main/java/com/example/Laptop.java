package com.example;

public class Laptop extends Device {
    private int ramGB;

    public Laptop(String name, double price, int availableCopies, String brand, int warrantyMonths, int ramGB) {
        super(name, price, availableCopies, brand, warrantyMonths);
        this.ramGB = ramGB;
    }

    @Override
    public String getCategory() { return "Device -> Laptop"; }

    @Override
    public String getSpecificDetails() {
        return String.format("Brand: %s, Warranty: %d Mos, RAM: %dGB", 
                getBrand(), getWarrantyMonths(), ramGB);
    }

    public int getRamGB() { return ramGB; }
    public void setRamGB(int ramGB) { this.ramGB = ramGB; }
}