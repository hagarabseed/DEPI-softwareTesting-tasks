package com.example;

public abstract class Clothing extends Item {
    private String size;
    private String color;

    public Clothing(String name, double price, int availableCopies, String size, String color) {
        super(name, price, availableCopies);
        this.size = size;
        this.color = color;
    }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}