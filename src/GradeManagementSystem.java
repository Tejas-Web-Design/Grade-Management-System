/*
 * Project Name : Grade Management System
 * Author       : Tejasri Konidena
 * Role         : Java Intern - Developers Arena
 * Description  : Menu-driven application for managing
 *                student grades and performance reports.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GradeManagementSystem {

    private static final int SUBJECT_COUNT = 5;

    private static ArrayList<StudentGrade> students =
            new ArrayList<>();

    private static Scanner scanner =
            new Scanner(System.in);

    private static String[] subjects = {
            "Mathematics",
            "Science",
            "English",
            "History",
            "Computer"
    };

    public static void main(String[] args) {

        displayWelcomeMessage();

        int choice;

        do {

            displayMenu();

            choice = getValidMenuChoice();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewAllStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    calculateAverages();
                    break;

                case 5:
                    findTopPerformer();
                    break;

                case 6:
                    ReportGenerator.generateReport(students);
                    break;

                case 7:
                    System.out.println("\nThank you for using Grade Management System!");
                    System.out.println("Developed by Tejasri Konidena");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        scanner.close();
    }

    /**
     * Welcome Screen
     */
    private static void displayWelcomeMessage() {

        System.out.println("====================================================");
        System.out.println("            GRADE MANAGEMENT SYSTEM");
        System.out.println("====================================================");
        System.out.println("Developer : Tejasri Konidena");
        System.out.println("Role      : Java Intern - Developers Arena");
        System.out.println("====================================================");
    }

    /**
     * Main Menu
     */
    private static void displayMenu() {

        System.out.println("\n================ MENU ================");
        System.out.println("1. Add Student Marks");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Calculate Averages");
        System.out.println("5. Find Top Performer");
        System.out.println("6. Generate Report");
        System.out.println("7. Exit");
        System.out.println("======================================");
        System.out.print("Enter your choice: ");
    }

    /**
     * Add Student
     */
    private static void addStudent() {

        System.out.println("\n========== ADD STUDENT ==========");

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Student name cannot be empty!");
            return;
        }

        double[] marks = new double[SUBJECT_COUNT];

        for (int i = 0; i < SUBJECT_COUNT; i++) {

            marks[i] = getValidMark(subjects[i]);
        }

        StudentGrade student =
                new StudentGrade(name, marks);

        students.add(student);

        System.out.println("\n ✅ Student added successfully!");
    }

    /**
     * View All Students
     */
    private static void viewAllStudents() {

        if (students.isEmpty()) {

            System.out.println("\nNo student records found!");
            return;
        }

        System.out.println("\n====================================================================================");
        System.out.printf("%-20s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                "Name",
                "Math",
                "Science",
                "English",
                "History",
                "Computer",
                "Average");

        System.out.println("====================================================================================");

        for (StudentGrade student : students) {

            double[] marks = student.getMarks();

            double average =
                    GradeCalculator.calculateAverage(marks);

            System.out.printf(
                    "%-20s %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f%n",
                    student.getName(),
                    marks[0],
                    marks[1],
                    marks[2],
                    marks[3],
                    marks[4],
                    average
            );
        }
    }

    /**
     * Search Student
     */
    private static void searchStudent() {

        if (students.isEmpty()) {

            System.out.println("No student records available.");
            return;
        }

        System.out.print("\nEnter student name to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;

        for (StudentGrade student : students) {

            if (student.getName()
                    .equalsIgnoreCase(searchName)) {

                student.displayStudent();

                double average =
                        GradeCalculator.calculateAverage(
                                student.getMarks());

                System.out.println("Average : "
                        + String.format("%.2f", average));

                System.out.println("Grade   : "
                        + GradeCalculator.getGrade(average));

                found = true;
            }
        }

        if (!found) {

            System.out.println("Student not found!");
        }
    }

    /**
     * Calculate Student Averages
     */
    private static void calculateAverages() {

        if (students.isEmpty()) {

            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n============= 📊  STUDENT AVERAGES =============");

        for (StudentGrade student : students) {

            double average =
                    GradeCalculator.calculateAverage(
                            student.getMarks());

            String grade =
                    GradeCalculator.getGrade(average);

            System.out.printf(
                    "%-20s Average = %-8.2f Grade = %s%n",
                    student.getName(),
                    average,
                    grade
            );
        }
    }

    /**
     * Find Top Performer
     */
    private static void findTopPerformer() {

        if (students.isEmpty()) {

            System.out.println("No student records available.");
            return;
        }

        StudentGrade topper = students.get(0);

        double highestAverage =
                GradeCalculator.calculateAverage(
                        topper.getMarks());

        for (StudentGrade student : students) {

            double average =
                    GradeCalculator.calculateAverage(
                            student.getMarks());

            if (average > highestAverage) {

                highestAverage = average;
                topper = student;
            }
        }

        System.out.println("\n============= 🏆  TOP PERFORMER =============");

        System.out.println("Student Name : "
                + topper.getName());

        System.out.printf("Average Marks : %.2f%n",
                highestAverage);

        System.out.println("Grade : "
                + GradeCalculator.getGrade(
                highestAverage));
    }

    /**
     * Input Validation for Marks
     */
    private static double getValidMark(
            String subjectName) {

        double mark;

        while (true) {

            try {

                System.out.print(
                        "Enter "
                                + subjectName
                                + " Marks (0-100): ");

                mark =
                        Double.parseDouble(
                                scanner.nextLine());

                if (mark >= 0 && mark <= 100) {

                    return mark;
                }

                System.out.println(
                        "Marks must be between 0 and 100.");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a number.");
            }
        }
    }

    /**
     * Menu Choice Validation
     */
    private static int getValidMenuChoice() {

        while (true) {

            try {

                return Integer.parseInt(
                        scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.print(
                        "Invalid input! Enter a valid choice: ");
            }
        }
    }
}