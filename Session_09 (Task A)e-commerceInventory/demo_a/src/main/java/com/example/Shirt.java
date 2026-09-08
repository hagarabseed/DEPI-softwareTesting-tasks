package com.example;

public class Shirt extends Clothing implements Discountable {
    private String material;
    private double discountRate = 0.10;

    public Shirt(String name, double price, int availableCopies, String size, String color, String material) {
        super(name, price, availableCopies, size, color);
        this.material = material;
    }

    public Shirt(String name, double price, int availableCopies, String size, String color, String material, double discountRate) {
        super(name, price, availableCopies, size, color);
        this.material = material;
        this.discountRate = discountRate;
    }

    @Override
    public double getDiscount() { return discountRate; }
    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }

    @Override
    public String getCategory() { return "Clothing -> Shirt"; }

    @Override
    public String getSpecificDetails() {
        return String.format("Size: %s, Color: %s, Material: %s", getSize(), getColor(), material);
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}