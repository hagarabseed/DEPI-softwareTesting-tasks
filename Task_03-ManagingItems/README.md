# Assignment: Java Collections - Item Management System

## Overview
This module implements a Java solution for a comprehensive item data management system as part of the **DEPI - Software Testing Track (Session 08)**.

The system demonstrates how item data can be stored, accessed, searched, modified, and displayed using standard array types and Java Collections Framework structures, selecting the optimal data structure for distinct operational tasks.

---

## Project Architecture & Data Structures

The project is organized into a Maven structure with key data handling logic divided across domain classes and services:

1. **`1D Array`**: Fixed-size linear array utilized for small, unchanging sets of categories where size is predetermined.
2. **`2D Array`**: Matrix layout chosen for direct tabular numerical mapping, such as raw `Item ID` to `Price` relationships.
3. **`ArrayList`**: Dynamic ordered list implementation providing fast index-based retrieval for catalog management.
4. **`LinkedList`**: Doubly-linked list utilized for dynamic queues (e.g., viewing history) requiring high-frequency additions or removals at boundaries (`addFirst`, `removeLast`).
5. **`HashSet`**: Unordered, hashtable-backed set implementation ensuring strict collection uniqueness by filtering duplicate entries.
6. **`HashMap`**: Key-value pairs map providing $O(1)$ fast lookup performance for querying item details directly by unique primary keys like `Item ID`.
7. **`Iterator`**: Traversal interface used to safely iterate over collections and remove specific elements without triggering concurrent modification errors.

---

## Key Features & Implementations

* **Encapsulation & Domain Modeling**:
  * Employs an `Item` class to encapsulate core properties (`id`, `name`, `price`) into clean, structured objects rather than loose variables.
* **Java Collections Framework Integration**:
  * Utilizes `java.util.*` data structures to match real-world data manipulation needs against algorithm performance.
* **Maven Standards**:
  * Organized under a standard Maven project structure (`com.example`) using Java 17 for builds and dependency execution.

---

## Author
Hagar Mahmoud Ahmed

* **Track:** Software Testing Track (DEPI)
* **Instructor:** Dr. Mina Younan