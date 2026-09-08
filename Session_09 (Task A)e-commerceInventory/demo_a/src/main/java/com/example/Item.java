package com.example;

public abstract class Item {
    private String name;
    private double price;
    private int availableCopies;

    public Item(String name, double price, int availableCopies) {
        this.name = name;
        this.price = price;
        this.availableCopies = availableCopies;
    }

    public void display() {
        System.out.printf("%-20s | %-20s | $%-8.2f | Stock: %-4d | %s%n", 
                getCategory(), name, price, availableCopies, getSpecificDetails());
    }

    public abstract String getCategory();
    public abstract String getSpecificDetails();

    public boolean sell() {
        if (availableCopies > 0) {
            availableCopies--;
            return true;
        } else {
            System.out.println("Error: '" + name + "' is out of stock!");
            return false;
        }
    }

    public void returnItem() {
        availableCopies++;
    }

    public double getFinalPrice() {
        if (this instanceof Discountable discountable) {
            return price * (1 - discountable.getDiscount());
        }
        return price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getAvailableCopies() { return availableCopies; }
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}