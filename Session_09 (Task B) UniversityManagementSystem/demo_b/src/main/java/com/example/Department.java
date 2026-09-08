package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
    private String name;
    private final List<Course> courses;
    private final List<Student> students;

    public Department(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be null or empty.");
        }
        this.name = name;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        if (course != null && !courses.contains(course)) {
            courses.add(course);
        }
    }

    public void addStudent(Student student) {
        if (student != null && !students.contains(student)) {
            students.add(student);
        }
    }

    public void displayAllCourses() {
        System.out.println("\n========================================================================");
        System.out.println("                Department Courses: " + name);
        System.out.println("========================================================================");
        for (Course course : courses) {
            System.out.println("-> " + course);
        }
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}