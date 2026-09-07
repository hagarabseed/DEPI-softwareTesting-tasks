package com.example;

public class Item {
    private int id;
    private String title;
    private String size;
    private double price;
    private int avalQuantity;
    private String desc;

    public Item() {
        this.id = 0;
        this.title = "Unknown";
        this.size = "N/A";
        this.price = 0.0;
        this.avalQuantity = 0;
        this.desc = "No Description";
    }

    public Item(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.size = "Standard";
        this.avalQuantity = 1;
        this.desc = "No Description";
    }

    public Item(int id, String title, String size, double price, int avalQuantity, String desc) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.price = price;
        this.avalQuantity = avalQuantity;
        this.desc = desc;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getAvalQuantity() { return avalQuantity; }
    public void setAvalQuantity(int avalQuantity) { this.avalQuantity = avalQuantity; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

    public void display() {
        System.out.printf("%-5d | %-15s | %-10s | %-10.2f | %-8d | %-20s%n", 
                id, title, size, price, avalQuantity, desc);
    }
}