package com.example.model;

public class Instructor extends Person {
    private String department;

    public Instructor(String id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public void displayDetails() { // Polymorphism
        System.out.printf("[INSTRUCTOR] ID: %-8s | Name: %-15s | Email: %-25s | Department: %s\n",
                getId(), getName(), getEmail(), department);
    }
}