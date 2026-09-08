package com.example;

public class LabCourse extends Course {

    public LabCourse(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "Lab";
    }
}