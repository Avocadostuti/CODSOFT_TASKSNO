
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalMarks = 0;
        int numberOfSubjects;

        System.out.println("================================");
        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("================================");

        // Enter number of subjects
        System.out.print("Enter number of subjects: ");
        numberOfSubjects = sc.nextInt();

        while (numberOfSubjects <= 0) {
            System.out.print("Please enter a valid number: ");
            numberOfSubjects = sc.nextInt();
        }

        // Input marks for each subject
        for (int i = 1; i <= numberOfSubjects; i++) {

            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            int marks = sc.nextInt();

            while (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Enter marks between 0 and 100.");
                System.out.print("Enter marks again: ");
                marks = sc.nextInt();
            }

            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage =
                (double) totalMarks / numberOfSubjects;

        // Calculate grade
        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("\n================================");
        System.out.println("         STUDENT RESULTS");
        System.out.println("================================");

        System.out.println("Total Marks: " + totalMarks
                + " / " + (numberOfSubjects * 100));

        System.out.printf("Average Percentage: %.2f%%\n",
                averagePercentage);

        System.out.println("Grade: " + grade);

        System.out.println("================================");

        sc.close();
    }
}
