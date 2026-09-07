# Assignment 02: Java OOP - Soccer League System

## Overview
This module implements an object-oriented Java solution for a soccer league management system as part of the **DEPI - Software Testing Track (Session 04)**

The system manages players, teams, matches, and match goals while automatically tracking standings, goal statistics, and generating match detail reports in full compliance with OOP principles and structural relationships.

---

## System Architecture & Classes

The design comprises **five core domain classes** and an enumerated type as required by the assignment specification:

1. **`PlayerRole`**: An enum defining available position roles (`GOALKEEPER`, `DEFENDER`, `MIDFIELDER`, `FORWARD`).
2. **`Player`**: Represents an individual athlete with attributes for `name`, `playerNum`, and `role`.
3. **`Team`**: Represents a soccer team with dynamic roster management, total accumulated `goals`, and total league `points`.
4. **`Goal`**: Records specific scoring events containing the `matchId`, the scoring `Player`, and the exact `minute` of the goal.
5. **`Match`**: Manages a fixture between `homeTeam` and `awayTeam`, tracks live match goals, and determines the match outcome.
6. **`Schedule`**: Holds all participating teams and matches, handles league ranking logic, and renders printable tables and match summary reports.

---

## OOP & Relationship Features

* **Composition & Aggregation**:
  * `Team` contains a list of its registered `Player` instances (`ArrayList<Player>`).
  * `Match` holds references to two `Team` instances (Home and Away) and a collection of `Goal` events (`ArrayList<Goal>`).
  * `Schedule` acts as the central hub holding all league `Team` instances and `Match` fixtures (`ArrayList<Match>`).
* **Collections & Data Processing**:
  * Utilizes `java.util.ArrayList` across all entities for dynamic list operations.
  * Employs `java.util.Collections.sort` with custom `Comparator` implementations to rank teams primarily by accumulated points and secondarily by goal counts.
* **Encapsulation & Architecture**:
  * Fully encapsulated domain model with private fields accessible via standard getters and setters.
  * Maven-compliant multi-package folder structure (`com.league`).

---

## Author
Hagar Mahmoud Ahmed

* **Track:** Software Testing Track (DEPI)
* **Instructor:** Dr. Mina Younan