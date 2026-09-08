package com.example;

public class Projector extends Device {
    private int lumens;

    public Projector(String name, double price, int availableCopies, String brand, int warrantyMonths, int lumens) {
        super(name, price, availableCopies, brand, warrantyMonths);
        this.lumens = lumens;
    }

    @Override
    public String getCategory() { return "Device -> Projector"; }

    @Override
    public String getSpecificDetails() {
        return String.format("Brand: %s, Warranty: %d Mos, Lumens: %d", 
                getBrand(), getWarrantyMonths(), lumens);
    }

    public int getLumens() { return lumens; }
    public void setLumens(int lumens) { this.lumens = lumens; }
}