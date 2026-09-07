package com.example;

import java.util.Date;

public class Bill {
    private static int billCounter = 1;
    private int billId;
    private Cart cart;
    private double totalAmount;
    private Date issueDate;

    public Bill(Cart cart) {
        this.billId = billCounter++;
        this.cart = cart;
        this.issueDate = new Date();
        this.totalAmount = cart.calcTotal();
    }

    public int getBillId() { return billId; }
    public Cart getCart() { return cart; }
    public double getTotalAmount() { return totalAmount; }
    public Date getIssueDate() { return issueDate; }

    public void printBill() {
        System.out.println("\n================ STORE BILL ================");
        System.out.println("Bill ID: " + billId + " | Date: " + issueDate);
        if (cart != null && cart.getCustomer() != null) {
            System.out.println("Customer: " + cart.getCustomer().getName() + " (ID: " + cart.getCustomer().getId() + ")");
        }
        System.out.println("--------------------------------------------");
        if (cart != null) {
            cart.displayCartItems();
        }
        System.out.println("--------------------------------------------");
        System.out.printf("Total Amount Payable: %.2f EGP%n", totalAmount);
        System.out.println("============================================\n");
    }
}