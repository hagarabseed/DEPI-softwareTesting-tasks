package com.example;

public class Hat extends Clothing {
    private String style;

    public Hat(String name, double price, int availableCopies, String size, String color, String style) {
        super(name, price, availableCopies, size, color);
        this.style = style;
    }

    @Override
    public String getCategory() { return "Clothing -> Hat"; }

    @Override
    public String getSpecificDetails() {
        return String.format("Size: %s, Color: %s, Style: %s", getSize(), getColor(), style);
    }

    public String getStyle() { return style; }
    public void setStyle(String style) { this.style = style; }
}