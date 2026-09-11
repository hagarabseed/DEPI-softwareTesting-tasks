```markdown
# Student Management System (DEPI GP Task)

A robust, terminal-based Java application designed to manage student records, courses, instructors, grades, and attendance tracking. Built to fulfill the Session 11 Graduation Project requirement for the **Digital Egypt Pioneers Initiative (DEPI) - Software Testing Track**.

---

## Features

* **Student CRUD Management**: Register, update details, view, and delete student records cleanly.
* **Course Administration**: Add new courses and view available offerings.
* **Instructor Management**: Model instructor entities with department associations.
* **Grade Processing**: Assign numerical grades (0–100) per course and automatically compute individual average GPAs.
* **Attendance Tracking**: Track session attendance and calculate live attendance percentages.
* **Developer & Tester Validations**:
  * Strict regular expression (Regex) pattern checking for email formatting (requires `@` and `.com`).
  * Scanner buffer protection and type safety against invalid user inputs (e.g., preventing crashes on letters where numbers are expected).
  * Unique ID verification to prevent duplicate student or course records.
  * Range constraints for numerical scores (0–100).

---

## Architecture & OOP Implementation

This system adheres strictly to fundamental **Object-Oriented Programming (OOP)** principles:

| Principle | Implementation Details |
| :--- | :--- |
| **Abstraction** | Enforced via the `Person` abstract class and `SystemOperations` interface to separate contract from implementation. |
| **Encapsulation** | Private field scoping across all models, accessed strictly via public getters/setters and unmodifiable collection wrappers. |
| **Inheritance** | Both `Student` and `Instructor` extend the base abstract class `Person` to reuse state (`id`, `name`, `email`). |
| **Polymorphism** | Runtime method overriding of `displayDetails()` across different subtypes, alongside interface-driven service contracts. |

---

## Repository Structure

```text
src/main/java/com/example/
├── exception/
│   ├── DuplicateEntityException.java   # Custom exception for duplicate records
│   └── EntityNotFoundException.java    # Custom exception for missing records
├── model/
│   ├── Person.java                     # Base abstract class
│   ├── Student.java                    # Extended model for student entities
│   ├── Instructor.java                 # Extended model for instructor entities
│   ├── Course.java                     # Course data model
│   └── Grade.java                      # Grade model linking course and score
├── service/
│   ├── SystemOperations.java           # Main management interface
│   ├── StudentManager.java             # Core implementation of management operations
│   └── GradeService.java               # Business logic for grading calculations
├── util/
│   └── ValidationUtils.java            # Regex & string validation utilities
└── Main.java                           # CLI application entry point with error handling

```
---

## 🧪 Quality Assurance & Test Scenarios

The system includes built-in safeguards designed to pass strict QA validation:

* **Email Format Enforcement**: Rejects invalid formats (`student@domain`, `user.com`, `user@domain.org`) and requires valid structural patterns ending in `.com`.
* **Duplicate Prevention**: Prevents creation of records with duplicate IDs, throwing managed `DuplicateEntityException` instances.
* **Boundary Checks**: Restricts numeric grade entries to valid values within $0 \le \text{grade} \le 100$.
---

## Author
Hagar Mahmoud Ahmed

* **Track:** Software Testing Track (DEPI)
* **Instructor:** Dr. Mina Younan