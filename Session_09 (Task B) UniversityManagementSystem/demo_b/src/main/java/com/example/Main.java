package com.example;

public class Main {
    public static void main(String[] args) {
        Department csDept = new Department("Computer Science");

        Course cs101 = new TheoryCourse("CS101 - Programming Fundamentals");
        Course cs102 = new LabCourse("CS102 - Data Structures Lab");
        Course cs103 = new TheoryCourse("CS103 - Database Systems");
        Course cs104 = new LabCourse("CS104 - Software Engineering Lab");

        csDept.addCourse(cs101);
        csDept.addCourse(cs102);
        csDept.addCourse(cs103);
        csDept.addCourse(cs104);

        Student alice = new Student("Alice Johnson");
        Student bob = new Student("Bob Smith");

        csDept.addStudent(alice);
        csDept.addStudent(bob);

        System.out.println("================ Enrolling Students ================");
        alice.enrollInCourse(cs101);
        alice.enrollInCourse(cs102);

        bob.enrollInCourse(cs103);
        bob.enrollInCourse(cs104);

        csDept.displayAllCourses();

        System.out.println("\n================ Student Enrolments ================");
        alice.displayEnrolledCourses();
        bob.displayEnrolledCourses();
    }
}