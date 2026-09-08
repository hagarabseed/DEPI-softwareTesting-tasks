# Task A: Java Object-Oriented Programming - E-Commerce Inventory & Cart Management System

## Overview
This module implements a Java solution for an e-commerce inventory and shopping cart management system as part of the **DEPI - Software Testing Track (Session 09 - Task A)**.

The system demonstrates core Object-Oriented Programming (OOP) principles—including abstraction, inheritance, polymorphism, interface implementation, and state management—to build a console-based backend for product catalog browsing, cart operations, stock tracking, and checkout workflows.

---

## Class Architecture

```text
                       +-------------------+
                       |    <<abstract>>   |
                       |       Item        |
                       +-------------------+
                                 ^
        +------------------------+------------------------+
        |                                                 |
+---------------+                                 +---------------+
|  <<abstract>> |                                 |  <<abstract>> |
|   Clothing    |                                 |    Device     |
+---------------+                                 +---------------+
   ^    ^    ^                                       ^    ^    ^
   |    |    +---------------+                       |    |    +---------------+
   |    +----------+         |                       |    +----------+         |
+-------+      +-------+ +-------+               +-------+      +-------+ +-----------+
| Shirt |      | Socks | |  Hat  |               |Laptop |      |Printer| | Projector |
+-------+      +-------+ +-------+               +-------+      +-------+ +-----------+

```

---

## Project Architecture & Data Structures

The project is organized into a Maven structure with key domain logic divided across specialized classes and interfaces:

* **`Item` (Abstract Base Class)**: Root class encapsulating core attributes (`name`, `price`, `availableCopies`) and methods (`sell()`, `returnItem()`, `getFinalPrice()`), and defining abstract methods like `getCategory()`.
* **`Clothing` (Abstract Subclass)**: Extends `Item` to define domain-specific attributes for apparel (`size`, `color`).
* **`Device` (Abstract Subclass)**: Extends `Item` to define domain-specific attributes for electronic hardware (`brand`, `warrantyMonths`).
* **Concrete Product Classes (`Shirt`, `Socks`, `Hat`, `Laptop`, `Printer`, `Projector`)**: Subclasses defining specific product properties (e.g., `material`, `ramGB`, `lumens`) and dynamic category descriptions.
* **`Discountable` (Interface)**: Contract abstraction implemented by eligible products (`Shirt`, `Printer`) to declare dynamic discount rates.
* **`Cart`**: Manages selected items, calculates total costs, handles itemized receipts, and coordinates order checkout routines.
* **`Main`**: Interactive CLI application loop handling console options, `Scanner` input, and workflow routing.

---

## Key Features & Implementations

* **Encapsulation & Domain Modeling**:
* Employs strict encapsulation using `private` fields with public accessors and mutators across all domain entities.


* **Polymorphism & Dynamic Dispatch**:
* Implements runtime polymorphism via abstract method overriding (`getCategory()`, `getSpecificDetails()`) across concrete classes.


* **Real-Time Stock Allocation**:
* Reserves stock immediately upon adding to cart (`sell()`) and handles auto-restocking upon removal (`returnItem()`) or returns.


* **Defensive Copying & Mutability Protection**:
* Exposes unmodifiable cart list views (`Collections.unmodifiableList`) to preserve cart state integrity.


* **Maven Standards**:
* Organized under standard Maven conventions (`com.example`) targeting Java 17 for builds and execution.



---

## Project Structure

```text
├── pom.xml
└── src
    └── main
        └── java
            └── com
                └── example
                    ├── Cart.java
                    ├── Clothing.java
                    ├── Device.java
                    ├── Discountable.java
                    ├── Hat.java
                    ├── Item.java
                    ├── Laptop.java
                    ├── Main.java
                    ├── Printer.java
                    ├── Projector.java
                    ├── Shirt.java
                    └── Socks.java

```

---

## Author

Hagar Mahmoud Ahmed

* **Track:** Software Testing Track (DEPI)
* **Instructor:** Dr. Mina Younan
