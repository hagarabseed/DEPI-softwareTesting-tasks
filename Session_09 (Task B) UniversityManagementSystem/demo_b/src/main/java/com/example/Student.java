package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private String name;
    private final List<Course> enrolledCourses;

    public Student(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty.");
        }
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        if (course == null) {
            System.out.println("-> Error: Cannot enroll in a null course.");
            return;
        }
        if (enrolledCourses.contains(course)) {
            System.out.println("-> Student '" + name + "' is already enrolled in '" + course.getName() + "'");
            return;
        }
        enrolledCourses.add(course);
        System.out.println("-> Student '" + name + "' enrolled in '" + course.getName() + "'");
    }

    public void displayEnrolledCourses() {
        System.out.println("\nCourses enrolled for " + name + ":");
        if (enrolledCourses.isEmpty()) {
            System.out.println("  No courses currently enrolled.");
        } else {
            for (Course course : enrolledCourses) {
                System.out.println("  - " + course);
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Course> getEnrolledCourses() {
        return Collections.unmodifiableList(enrolledCourses);
    }
}