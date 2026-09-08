package com.example;

public class TheoryCourse extends Course {

    public TheoryCourse(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "Theory";
    }
}