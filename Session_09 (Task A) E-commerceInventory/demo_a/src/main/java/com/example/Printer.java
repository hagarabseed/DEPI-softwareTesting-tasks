package com.example;

public class Printer extends Device implements Discountable {
    private boolean isColor;
    private double discountRate = 0.15;

    public Printer(String name, double price, int availableCopies, String brand, int warrantyMonths, boolean isColor) {
        super(name, price, availableCopies, brand, warrantyMonths);
        this.isColor = isColor;
    }

    public Printer(String name, double price, int availableCopies, String brand, int warrantyMonths, boolean isColor, double discountRate) {
        super(name, price, availableCopies, brand, warrantyMonths);
        this.isColor = isColor;
        this.discountRate = discountRate;
    }

    @Override
    public double getDiscount() { return discountRate; }
    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }

    @Override
    public String getCategory() { return "Device -> Printer"; }

    @Override
    public String getSpecificDetails() {
        return String.format("Brand: %s, Warranty: %d Mos, Color: %s", 
                getBrand(), getWarrantyMonths(), isColor ? "Yes" : "No");
    }

    public boolean isColor() { return isColor; }
    public void setColor(boolean isColor) { this.isColor = isColor; }
}