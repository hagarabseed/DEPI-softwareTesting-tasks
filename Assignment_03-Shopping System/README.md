# Assignment 03: Java OOP - Shopping System in a Store

## Overview
This module implements an object-oriented Java solution for a store shopping system as part of the **DEPI - Software Testing Track (Session 04)**.

The system manages customers, store inventory, shopping carts, and bill generation while adhering strictly to OOP principles, structural relationships, and input validations.

---

## System Architecture & Classes

The design comprises **four core classes** as required by the assignment specification:

1. **`Item`**: Represents a product available in the store with attributes like `id`, `title`, `size`, `price`, `avalQuantity`, and `desc`.
2. **`Customer`**: Represents a customer profile with automated ID generation, unique contact details, and input validations (Name, Egypt Phone Format `+20`, Email).
3. **`Cart`**: Manages a collection of selected items and their quantities for a specific customer. Calculates subtotal and applies automatic discounts (e.g., 20% off for purchases $\ge$ 1000 EGP).
4. **`Bill`**: Generates an itemized official invoice from a `Cart`, linking customer details, issue timestamp, itemized breakdown, and final payable amount.

---

## OOP & Relationship Features

* **Composition & Aggregation**:
  * `Customer` owns a list of `Cart` instances (`List<Cart>`).
  * `Cart` contains collections of `Item` objects and their corresponding quantities.
  * `Bill` holds a reference to a `Cart` to process payment details.
* **Collections**:
  * Utilizes `java.util.ArrayList` across all collections for dynamic sizing and data manipulation.
* **Encapsulation & Validation**:
  * All fields are private with proper Getters and Setters.
  * Regex validation for Egyptian phone numbers (`+20...`) and standard email patterns.

---

## Author
Hagar Mahmoud Ahmed

* **Track:** Software Testing Track (DEPI)

* **Instructor:** Dr. Mina Younan
    