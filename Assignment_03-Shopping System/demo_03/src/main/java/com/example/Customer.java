package com.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static int counter = 1; 
    private int id;
    private String name;
    private String number;
    private String email;
    private List<Cart> carts; //Aggregation relationship

    public Customer() {
        this.id = counter++;
        this.carts = new ArrayList<>();
    }

    public Customer(String name, String number, String email) {
        this();
        setName(name);
        setNumber(number);
        setEmail(email);
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) {
        if (name != null && name.matches("^[a-zA-Z\\u0600-\\u06FF\\s]+$")) {
            this.name = name;
        } else {
            System.out.println("Invalid Name: Name cannot contain special characters or digits.");
            this.name = "Invalid Name";
        }
    }

    public String getNumber() { return number; }

    public void setNumber(String number) {
        if (number != null && number.matches("^\\+20\\d{10}$")) {
            this.number = number;
        } else {
            System.out.println("Invalid Phone Number: Must start with +20 followed by 10 digits (e.g. +201012345678).");
            this.number = "Invalid Number";
        }
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".com")) {
            this.email = email;
        } else {
            System.out.println("Invalid Email: Email must contain '@' and '.com'.");
            this.email = "Invalid Email";
        }
    }

    public List<Cart> getCarts() { return carts; }

    public void addCart(Cart cart) {
        if (cart != null) {
            this.carts.add(cart);
            cart.setCustomer(this);
        }
    }

    public void displayCustomerInfo() {
        System.out.printf("%-5d | %-20s | %-15s | %-25s%n", id, name, number, email);
    }
}