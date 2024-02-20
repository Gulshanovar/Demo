import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Take input for marks in five subjects
        System.out.print("Enter marks for Subject 1: ");
        int subject1Marks = scanner.nextInt();

        System.out.print("Enter marks for Subject 2: ");
        int subject2Marks = scanner.nextInt();

        System.out.print("Enter marks for Subject 3: ");
        int subject3Marks = scanner.nextInt();

        System.out.print("Enter marks for Subject 4: ");
        int subject4Marks = scanner.nextInt();

        System.out.print("Enter marks for Subject 5: ");
        int subject5Marks = scanner.nextInt();

        // Calculate total marks
        int totalMarks = subject1Marks + subject2Marks + subject3Marks + subject4Marks + subject5Marks;

        // Calculate average percentage
        double averagePercentage = totalMarks / 5.0;

        // Display the result
        System.out.println("\n===== Result =====");
        System.out.println("Subject 1 Marks: " + subject1Marks);
        System.out.println("Subject 2 Marks: " + subject2Marks);
        System.out.println("Subject 3 Marks: " + subject3Marks);
        System.out.println("Subject 4 Marks: " + subject4Marks);
        System.out.println("Subject 5 Marks: " + subject5Marks);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");

        // Close the Scanner
        scanner.close();
    }
}

