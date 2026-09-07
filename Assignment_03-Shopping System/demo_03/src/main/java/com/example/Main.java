package com.example;

public class Main {
    public static void main(String[] args) {
        // 1. Create Customers
        Customer c1 = new Customer("Hagar Mahmoud", "+201012345678", "hagar@gmail.com");
        Customer c2 = new Customer("Ahmed123", "01012345678", "ahmedgmail.com"); 

        System.out.printf("%-5s | %-20s | %-15s | %-25s%n", "ID", "Name", "Phone", "Email");
        System.out.println("---------------------------------------------------------------------");
        c1.displayCustomerInfo();
        c2.displayCustomerInfo();

        // 2. Create Items
        Item item1 = new Item(101, "Headphones", "Standard", 400.0, 5, "Noise Cancelling");
        Item item2 = new Item(102, "Keyboard", "Standard", 700.0, 3, "Mechanical RGB");

        System.out.println("\n----------------------------------------------------------------------------------");
        System.out.printf("%-5s | %-15s | %-10s | %-10s | %-8s | %-20s%n", 
                        "ID", "Title", "Size", "Price", "Qty", "Description");
        System.out.println("----------------------------------------------------------------------------------");
        item1.display();
        item2.display();
        System.out.println("----------------------------------------------------------------------------------\n");

        // 3. Create Cart & Add to Customer
        Cart cart = new Cart(c1);
        c1.addCart(cart);

        cart.addItem(item1, 1); 
        cart.addItem(item2, 1); 

        System.out.println("Total Items in Cart: " + cart.getNumberOfItems());

        // 4. Generate & Print Bill
        Bill bill = new Bill(cart);
        bill.printBill();
    }
}