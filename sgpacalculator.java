import java.util.Scanner;

public class sgpacalculator {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int numSubjects;

    // Method to accept student details
    void acceptDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        numSubjects = sc.nextInt();

        credits = new int[numSubjects];
        marks = new int[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Subject " + (i + 1) + ":");
            System.out.print("  Enter credits: ");
            credits[i] = sc.nextInt();
            System.out.print("  Enter marks: ");
            marks[i] = sc.nextInt();
        }
    }

    // Method to display student details
    void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Subjects:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("  Subject " + (i + 1) + ": Credits = " + credits[i] + ", Marks = " + marks[i]);
        }
    }

    // Method to calculate SGPA
    void calculateSGPA() {
        int totalCredits = 0;
        int weightedGradePoints = 0;

        for (int i = 0; i < numSubjects; i++) {
            int gradePoint = getGradePoint(marks[i]);
            weightedGradePoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        double sgpa = (double) weightedGradePoints / totalCredits;
        System.out.printf("SGPA: %.2f\n", sgpa);
    }

    // Helper method to convert marks to grade points
    int getGradePoint(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 40) return 5;
        else return 0; // Fail
    }



    public static void main(String[] args) {
        Student s = new Student();
        s.acceptDetails();
        s.displayDetails();
        s.calculateSGPA();
    }
}