package com.example;

public abstract class Course {
    private String name;

    public Course(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty.");
        }
        this.name = name;
    }

    public abstract String getType();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Type: %-8s | Course Name: %s", getType(), name);
    }
}