# ImpactTechnical

# NumberRangeSummarizerProject

![Java](https://img.shields.io/badge/Java-11%2B-blue.svg)
![Maven](https://img.shields.io/badge/Maven-3.6.0%2B-blue.svg)
![License](https://img.shields.io/badge/License-MIT-green.svg)

## Overview

**NumberRangeSummarizerProject** is a Java application that takes a comma-separated list of numbers and summarizes them into a range-based format. Built with Maven for project management and JUnit 5 for testing, this project ensures efficient handling of inputs, including duplicate removal and sorting.

---

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Running the Application](#running-the-application)
- [Running the Tests](#running-the-tests)
- [Contact](#contact)

---

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK) 11 or higher**
  - [Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **Apache Maven 3.6.0 or higher**
  - Install via Homebrew (macOS):
    ```bash
    brew update
    brew install maven
    ```
  - Verify installation:
    ```bash
    mvn -version
    ```

---

## Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/NumberRangeSummarizerProject.git
   ```

2. **Navigate to the Project Directory:**
   ```bash
   cd NumberRangeSummarizerProject
   ```

---

## Project Structure

```
NumberRangeSummarizerProject
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── example
│   │               ├── Main.java
│   │               ├── NumberRangeSummarizer.java
│   │               └── NumberRangeSummarizerImpl.java
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── NumberRangeSummarizerImplTest.java
├── target
│   └── (Generated files after build)
└── .vscode
    └── settings.json
```

- **`pom.xml`**: Maven configuration file.
- **`src/main/java/com/example/`**: Main application source files.
- **`src/test/java/com/example/`**: JUnit test classes.
- **`target/`**: Compiled classes and test reports.
- **`.vscode/settings.json`**: VS Code specific settings (if applicable).

---

## Running the Application

1. **Ensure You're in the Project Root Directory:**
   ```bash
   cd NumberRangeSummarizerProject
   ```

2. **Compile the Project:**
   ```bash
   mvn compile
   ```

3. **Run the Application:**
   ```bash
   mvn exec:java
   ```
   
   **Expected Output:**
   ```
   Input: 1,3,6,7,8,12,13,14,15,21,22,23,24,31
   Summary: 1, 3, 6-8, 12-15, 21-24, 31
   ```

---

## Running the Tests

1. **Navigate to the Project Root Directory:**
   ```bash
   cd NumberRangeSummarizerProject
   ```

2. **Execute the Tests:**
   ```bash
   mvn test
   ```
   
   **Expected Output:**
   ```
   [INFO] -------------------------------------------------------
   [INFO]  T E S T S
   [INFO] -------------------------------------------------------
   [INFO] Running com.example.NumberRangeSummarizerImplTest
   [INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0
   [INFO] 
   [INFO] Results:
   [INFO] 
   [INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0
   [INFO] 
   [INFO] BUILD SUCCESS
   ```

---

## Contact

For any questions or support, please reach out to [pmambambo2@gmail.com](mailto:pmambambo2@gmail.com).




