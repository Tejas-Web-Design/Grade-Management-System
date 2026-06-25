/*
 * Project Name : Grade Management System
 * Author       : Tejasri Konidena
 * GradeCalculator.java - Grade calculation utilities
 */

public class GradeCalculator {

    /**
     * Calculate average marks
     */
    public static double calculateAverage(double[] marks) {

        double total = 0;

        for (double mark : marks) {
            total += mark;
        }

        return total / marks.length;
    }

    /**
     * Find highest mark
     */
    public static double getHighestMark(double[] marks) {

        double highest = marks[0];

        for (double mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }

        return highest;
    }

    /**
     * Find lowest mark
     */
    public static double getLowestMark(double[] marks) {

        double lowest = marks[0];

        for (double mark : marks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }

        return lowest;
    }

    /**
     * Calculate grade category
     */
    public static String getGrade(double average) {

        if (average >= 90)
            return "A+";
        else if (average >= 80)
            return "A";
        else if (average >= 70)
            return "B";
        else if (average >= 60)
            return "C";
        else if (average >= 50)
            return "D";
        else
            return "F";
    }
}