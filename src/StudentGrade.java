/*
 * Project Name : Grade Management System
 * Author       : Tejasri Konidena
 * Role         : Java Intern - Developers Arena
 * Description  : Stores student information and marks, Student grade data class.
 */

public class StudentGrade {

    private String name;
    private double[] marks;

    public StudentGrade(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double[] getMarks() {
        return marks;
    }
    
    public void setName(String name) {
		this.name = name;
	}

	public void setMarks(double[] marks) {
		this.marks = marks;
	}

    /**
     * Display complete student information
     */
    public void displayStudent() {

        String[] subjects = {
                "Mathematics",
                "Science",
                "English",
                "History",
                "Computer"
        };

        System.out.println("\n--------------------------------");
        System.out.println("Student Name : " + name);

        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%-12s : %.2f%n",
                    subjects[i],
                    marks[i]);
        }

        System.out.println("--------------------------------");
    }
}