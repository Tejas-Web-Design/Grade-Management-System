# User Manual

## Grade Management System

### Introduction

The Grade Management System is designed to manage student academic performance records. Users can add student marks, calculate averages, assign grades, search student records, and generate reports.

---

## Main Menu

### 1. Add Student Marks

Allows the user to enter:

* Student Name
* Mathematics Marks
* Science Marks
* English Marks
* History Marks
* Computer Marks

Validation ensures marks remain between 0 and 100.

---

### 2. View All Students

Displays all students along with:

* Subject Marks
* Average Marks
* Grade Category

---

### 3. Search Student

Allows searching student information using student name.

Displays:

* Student Details
* Marks
* Average
* Grade

---

### 4. Calculate Averages

Calculates average marks for every student.

Formula:

Average = Total Marks ÷ Number of Subjects

---

### 5. Find Top Performer

Identifies the student with the highest average score.

Displays:

* Student Name
* Average Score
* Grade

---

### 6. Generate Report

Produces a class performance report containing:

* Student Name
* Average Score
* Grade Category
* Class Average

---

### 7. Exit

Closes the application safely.

---

## Grading System

| Average Marks | Grade |
| ------------- | ----- |
| 90 – 100      | A+    |
| 80 – 89       | A     |
| 70 – 79       | B     |
| 60 – 69       | C     |
| 50 – 59       | D     |
| Below 50      | F     |

---

## Input Validation

The system validates:

* Empty student names
* Invalid menu choices
* Marks below 0
* Marks above 100
* Non-numeric inputs

Error messages are displayed when invalid input is detected.
