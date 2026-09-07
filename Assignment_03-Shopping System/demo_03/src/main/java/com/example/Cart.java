package com.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;
    private List<Integer> quantities;
    private Customer customer;

    public Cart() {
        this.items = new ArrayList<>();
        this.quantities = new ArrayList<>();
    }

    public Cart(Customer customer) {
        this();
        this.customer = customer;
    }

    public void addItem(Item item, int quantity) {
        if (item == null) return;

        if (quantity > item.getAvalQuantity()) {
            System.out.println("Cannot add " + item.getTitle() + ". Requested quantity (" + quantity + ") exceeds available stock (" + item.getAvalQuantity() + ").");
            return;
        }

        items.add(item);
        quantities.add(quantity);
        System.out.println(quantity + "x " + item.getTitle() + " added to cart.");
    }

    public void removeItem(int itemId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == itemId) {
                items.remove(i);
                quantities.remove(i);
                System.out.println("Item removed successfully.");
                return;
            }
        }
        System.out.println("Item not found in cart.");
    }

    public void removeItem(Item item) {
        if (item != null) {
            removeItem(item.getId());
        }
    }

    public double calcTotal() {
        double subtotal = 0;
        for (int i = 0; i < items.size(); i++) {
            subtotal += items.get(i).getPrice() * quantities.get(i);
        }

        if (subtotal >= 1000) {
            return subtotal * 0.80;
        }
        return subtotal;
    }

    public void displayCartItems() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            int qty = quantities.get(i);
            System.out.printf("%-15s | Qty: %-3d | Price: %-8.2f | Subtotal: %.2f EGP%n",
                    item.getTitle(), qty, item.getPrice(), (item.getPrice() * qty));
        }
    }

    public List<Item> getItems() { return items; }
    public List<Integer> getQuantities() { return quantities; }
    public double getTotalPrice() { return calcTotal(); }
    public int getNumberOfItems() { return items.size(); }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}