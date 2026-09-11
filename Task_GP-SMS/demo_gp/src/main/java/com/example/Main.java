package com.example;

import com.example.exception.*;
import com.example.model.*;
import com.example.service.*;
import com.example.util.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SystemOperations manager = new StudentManager(); // Polymorphism via interface reference
        GradeService gradeService = new GradeService();

        // Seed initial data
        try {
            manager.addCourse(new Course("CS101", "Java Programming"));
        } catch (DuplicateEntityException e) {
            System.err.println("Initialization error: " + e.getMessage());
        }

        while (true) {
            printMenu();
            int choice = readIntInput("Select an option: ");

            switch (choice) {
                case 1 -> handleAddStudent(manager);
                case 2 -> handleUpdateStudent(manager);
                case 3 -> handleDeleteStudent(manager);
                case 4 -> handleAddCourse(manager);
                case 5 -> handleRecordGrade(manager, gradeService);
                case 6 -> handleRecordAttendance(manager);
                case 7 -> handleDisplayStudents(manager, gradeService);
                case 8 -> handleDisplayCourses(manager);
                case 0 -> {
                    System.out.println("Exiting System. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Error: Option must be between 0 and 8.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n==========================================");
        System.out.println("   GRADUATION PROJECT: STUDENT MANAGEMENT  ");
        System.out.println("==========================================");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Add Course");
        System.out.println("5. Record Grade");
        System.out.println("6. Record Attendance");
        System.out.println("7. Display All Students");
        System.out.println("8. Display All Courses");
        System.out.println("0. Exit");
    }

    // Input Helpers with Robust Validation

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Error: Field cannot be empty.");
        }
    }

    private static String readValidEmail(String prompt) {
        while (true) {
            String email = readNonEmptyString(prompt);
            if (ValidationUtils.isValidEmail(email)) {
                return email;
            }
            System.out.println("Error: Invalid email format! Must contain '@' and end with '.com' (e.g., john@domain.com).");
        }
    }

    private static int readIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Error: Input must be an integer.");
                scanner.nextLine();
            }
        }
    }

    private static double readDoubleInput(String prompt, double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine();
                if (value >= min && value <= max) return value;
                System.out.printf("Error: Value must be between %.1f and %.1f.\n", min, max);
            } catch (InputMismatchException e) {
                System.out.println("Error: Input must be a decimal number.");
                scanner.nextLine();
            }
        }
    }

    private static boolean readBooleanInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("y") || input.equals("yes")) return true;
            if (input.equals("false") || input.equals("n") || input.equals("no")) return false;
            System.out.println("Error: Enter 'yes'/'y' or 'no'/'n'.");
        }
    }

    // Operation Handlers

    private static void handleAddStudent(SystemOperations manager) {
        String id = readNonEmptyString("Enter Student ID: ");
        String name = readNonEmptyString("Enter Name: ");
        String email = readValidEmail("Enter Email (.com required): ");

        try {
            manager.addStudent(new Student(id, name, email));
            System.out.println("Success: Student registered successfully.");
        } catch (DuplicateEntityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleUpdateStudent(SystemOperations manager) {
        String id = readNonEmptyString("Enter Student ID to update: ");
        String name = readNonEmptyString("Enter New Name: ");
        String email = readValidEmail("Enter New Email (.com required): ");

        try {
            manager.updateStudent(id, name, email);
            System.out.println("Success: Student details updated.");
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleDeleteStudent(SystemOperations manager) {
        String id = readNonEmptyString("Enter Student ID to delete: ");
        try {
            manager.deleteStudent(id);
            System.out.println("Success: Student record removed.");
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleAddCourse(SystemOperations manager) {
        String code = readNonEmptyString("Enter Course Code: ");
        String name = readNonEmptyString("Enter Course Name: ");

        try {
            manager.addCourse(new Course(code, name));
            System.out.println("Success: Course added successfully.");
        } catch (DuplicateEntityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleRecordGrade(SystemOperations manager, GradeService gradeService) {
        try {
            String studentId = readNonEmptyString("Enter Student ID: ");
            Student student = manager.findStudentById(studentId);

            String courseCode = readNonEmptyString("Enter Course Code: ");
            Course course = manager.findCourseById(courseCode);

            double grade = readDoubleInput("Enter Grade (0 - 100): ", 0.0, 100.0);
            gradeService.assignGrade(student, course, grade);
            System.out.println("Success: Grade recorded.");
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleRecordAttendance(SystemOperations manager) {
        try {
            String studentId = readNonEmptyString("Enter Student ID: ");
            Student student = manager.findStudentById(studentId);

            boolean isPresent = readBooleanInput("Is student present? (y/n): ");
            student.recordAttendance(isPresent);
            System.out.println("Success: Attendance recorded.");
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleDisplayStudents(SystemOperations manager, GradeService gradeService) {
        System.out.println("\n--- Registered Students ---");
        if (manager.getAllStudents().isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        for (Student s : manager.getAllStudents()) {
            s.displayDetails();
            System.out.printf("   Average Score: %.2f\n", gradeService.calculateAverageGrade(s));
        }
    }

    private static void handleDisplayCourses(SystemOperations manager) {
        System.out.println("\n--- Available Courses ---");
        if (manager.getAllCourses().isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course c : manager.getAllCourses()) {
            System.out.println(c);
        }
    }
}