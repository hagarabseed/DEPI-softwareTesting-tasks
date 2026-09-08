package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private final List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (item.sell()) {
            items.add(item);
            System.out.println("-> '" + item.getName() + "' added to cart.");
        }
    }

    public void removeItem(Item item) {
        if (items.remove(item)) {
            item.returnItem();
            System.out.println("-> '" + item.getName() + "' removed from cart.");
        } else {
            System.out.println("-> Item not found in cart.");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getFinalPrice();
        }
        return total;
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("-> Cart is empty! Add items first.");
            return;
        }

        System.out.println("\n=========================== Itemized Receipt ===========================");
        System.out.printf("%-20s | %-20s | %-12s | %-10s%n", "Category", "Name", "Original", "Final Price");
        System.out.println("------------------------------------------------------------------------");
        
        for (Item item : items) {
            System.out.printf("%-20s | %-20s | $%-11.2f | $%-10.2f%n", 
                    item.getCategory(), item.getName(), item.getPrice(), item.getFinalPrice());
        }
        
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("Total Paid: $%.2f%n", calculateTotal());
        
        items.clear();
        System.out.println("Checkout completed successfully! Cart has been cleared.");
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}