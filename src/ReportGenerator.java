/*
 * Project Name : Grade Management System
 * Author       : Tejasri Konidena
 * ReportGenerator.java - Report generation class
 */

import java.util.ArrayList;

public class ReportGenerator {

    /**
     * Generate class performance report
     */
    public static void generateReport(
            ArrayList<StudentGrade> students) {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        double classAverage = 0;

        System.out.println("\n==================================================");
        System.out.println("             📈  PERFORMANCE REPORT");
        System.out.println("==================================================");

        for (StudentGrade student : students) {

            double average =
                    GradeCalculator.calculateAverage(
                            student.getMarks());

            classAverage += average;

            System.out.printf(
                    "%-20s Average: %-8.2f Grade: %s%n",
                    student.getName(),
                    average,
                    GradeCalculator.getGrade(average)
            );
        }

        classAverage /= students.size();

        System.out.println("--------------------------------------------------");
        System.out.printf("Class Average : %.2f%n",
                classAverage);
        System.out.println("==================================================");
    }
}