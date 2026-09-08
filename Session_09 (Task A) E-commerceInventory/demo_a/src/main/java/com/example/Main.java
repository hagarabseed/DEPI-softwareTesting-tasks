package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        List<Item> inventory = new ArrayList<>();
        inventory.add(new Shirt("Shirt", 25.99, 15, "L", "Black", "Cotton"));
        inventory.add(new Socks("Socks", 9.99, 20, "M", "White", 3));
        inventory.add(new Hat("Baseball Cap", 15.00, 10, "Free", "Red", "Sports"));
        inventory.add(new Laptop("Legion 5", 1150.00, 8, "Lenovo", 12, 16));
        inventory.add(new Printer("LaserJet", 200.00, 5, "HP", 24, true));
        inventory.add(new Projector("4K Projector", 450.00, 3, "Epson", 12, 3000));

        boolean exit = false;

        while (!exit) {
            System.out.println("\n========================================================================");
            System.out.println("                    Shopping Cart Management System                     ");
            System.out.println("========================================================================");
            System.out.println("1. View Store Inventory");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Return Item");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                scanner.next(); 
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\n================================ Store Inventory ========================================================");
                    System.out.printf("%-5s | %-20s | %-20s | %-9s | %-12s | %s%n", "ID", "Category", "Name", "Price", "Available", "Details");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    for (int i = 0; i < inventory.size(); i++) {
                        System.out.printf("[%02d]  | ", (i + 1));
                        inventory.get(i).display();
                    }
                }
                case 2 -> {
                    System.out.print("Enter Item ID to add to cart: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Error: Invalid ID! Please enter a valid numeric Item ID.");
                        scanner.next(); 
                        break;
                    }
                    int addId = scanner.nextInt() - 1;
                    if (addId >= 0 && addId < inventory.size()) {
                        cart.addItem(inventory.get(addId));
                    } else {
                        System.out.println("Error: Item ID out of range! Please choose an ID from the inventory list.");
                    }
                }
                case 3 -> {
                    System.out.println("\n============================ Shopping Cart ============================");
                    if (cart.getItems().isEmpty()) {
                        System.out.println("Your cart is empty.");
                    } else {
                        System.out.printf("%-20s | %-20s | %-10s | %-10s%n", "Category", "Name", "Original", "Final Price");
                        System.out.println("-----------------------------------------------------------------------");
                        for (Item item : cart.getItems()) {
                            System.out.printf("%-20s | %-20s | $%-9.2f | $%-10.2f%n", 
                                    item.getCategory(), item.getName(), item.getPrice(), item.getFinalPrice());
                        }
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.printf("Total Cost: $%.2f%n", cart.calculateTotal());
                    }
                }
                case 4 -> cart.checkout();
                case 5 -> {
                    System.out.print("Enter Item ID to return: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Error: Invalid ID! Please enter a valid numeric Item ID.");
                        scanner.next(); 
                        break;
                    }
                    int returnId = scanner.nextInt() - 1;
                    if (returnId >= 0 && returnId < inventory.size()) {
                        inventory.get(returnId).returnItem();
                        System.out.println("Item returned successfully! Updated stock for " 
                                + inventory.get(returnId).getName() + ": " 
                                + inventory.get(returnId).getAvailableCopies());
                    } else {
                        System.out.println("Error: Item ID out of range! Please choose an ID from the inventory list.");
                    }
                }
                case 6 -> {
                    exit = true;
                    System.out.println("Thank you for shopping with us!");
                }
                default -> System.out.println("Invalid option! Please choose between 1 and 6.");
            }
        }

        scanner.close();
    }
}