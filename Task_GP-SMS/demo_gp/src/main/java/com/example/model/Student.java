package com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends Person {
    private final List<Grade> grades; // Using the Grade class
    private int attendedSessions;
    private int totalSessions;

    public Student(String id, String name, String email) {
        super(id, name, email);
        this.grades = new ArrayList<>();
        this.attendedSessions = 0;
        this.totalSessions = 0;
    }

    public List<Grade> getGrades() {
        return Collections.unmodifiableList(grades);
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }

    public void recordAttendance(boolean isPresent) {
        this.totalSessions++;
        if (isPresent) {
            this.attendedSessions++;
        }
    }

    public double getAttendancePercentage() {
        if (totalSessions == 0) return 0.0;
        return ((double) attendedSessions / totalSessions) * 100;
    }

    @Override
    public void displayDetails() {
        System.out.printf("[STUDENT] ID: %-8s | Name: %-15s | Email: %-25s | Attendance: %5.1f%%\n",
                getId(), getName(), getEmail(), getAttendancePercentage());
    }
}