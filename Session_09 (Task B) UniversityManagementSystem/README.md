# Task B: Java OOP - University Course Management System

## Overview
This module implements an object-oriented Java solution for a university course management system as part of the **DEPI - Software Testing Track (Session 09 - Task B)**.

The system manages academic departments, student enrollments, and course offerings while supporting different course modalities (Theory vs. Lab). It dynamically handles enrollments and prints course directories in full compliance with core Object-Oriented Programming principles.

---

## System Architecture & Classes

The design comprises **six core classes** as required by the assignment specification:

1. **`Course`**: An abstract base class defining core properties (`name`) and abstract methods (`getType()`) common to all university courses.
2. **`TheoryCourse`**: A concrete class extending `Course` representing theoretical lecture-based courses.
3. **`LabCourse`**: A concrete class extending `Course` representing practical laboratory courses.
4. **`Student`**: Represents a student entity with attributes for `name` and an enrolled course directory.
5. **`Department`**: Represents an academic department managing available courses and registered students.
6. **`Main`**: The execution class that instantiates departments, builds course catalogues, enrolls students, and renders system outputs.

---

## OOP & Relationship Features

* **Abstraction & Inheritance**:
  * `Course` acts as an abstract superclass that cannot be directly instantiated.
  * `TheoryCourse` and `LabCourse` inherit common properties via `super(name)` constructor chaining.
* **Polymorphism & Dynamic Dispatch**:
  * `List<Course>` collections hold mixed instances of both `TheoryCourse` and `LabCourse` transparently.
  * Overridden `toString()` and `getType()` methods execute behavior based on runtime object types.
* **Encapsulation & Robustness**:
  * Fully encapsulated data fields with validation against empty states and null values.
  * Internal `List` attributes protected using `Collections.unmodifiableList()` to prevent unauthorized external mutation.
  * Built within a standard Maven multi-package structure (`com.example`).

---
## Project Structure

```text
src/main/java/com/example/
├── Course.java          # Abstract base class
├── TheoryCourse.java    # Concrete class extending Course
├── LabCourse.java      # Concrete class extending Course
├── Student.java        # Student entity & enrollment logic
├── Department.java     # Department entity managing courses & students
└── Main.java           # Application entry point
```
---

## Author
Hagar Mahmoud Ahmed

* **Track:** Software Testing Track (DEPI)
* **Instructor:** Dr. Mina Younan