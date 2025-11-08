import java.util.*;

public class CGPACalculator {
    
    // Function to convert total marks to grade point
    public static double getGradePoint(double total) {
        if (total >= 80) return 4.00;
        else if (total >= 75) return 3.75;
        else if (total >= 70) return 3.50;
        else if (total >= 65) return 3.25;
        else if (total >= 60) return 3.00;
        else if (total >= 55) return 2.75;
        else if (total >= 50) return 2.50;
        else if (total >= 45) return 2.25;
        else if (total >= 40) return 2.00;
        else return 0.00;
    }

    // Function to convert CGPA to letter grade
    public static String getLetterGrade(double cgpa) {
        if (cgpa >= 4.00) return "A+";
        else if (cgpa >= 3.75) return "A";
        else if (cgpa >= 3.50) return "A-";
        else if (cgpa >= 3.25) return "B+";
        else if (cgpa >= 3.00) return "B";
        else if (cgpa >= 2.75) return "B-";
        else if (cgpa >= 2.50) return "C+";
        else if (cgpa >= 2.25) return "C";
        else if (cgpa >= 2.00) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Student ID: ");
        String studentId = sc.nextLine();

        System.out.print("No. of Courses: ");
        int n = sc.nextInt();

        double totalGradePoints = 0, totalCredits = 0;
        double creditTaken = 0, creditEarned = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("\nC" + i + ":");
            System.out.print("Credit (Max 3): ");
            double credit = sc.nextDouble();
            System.out.print("CT (Max 30): ");
            double ct = sc.nextDouble();
            System.out.print("AT (Max 10): ");
            double at = sc.nextDouble();
            System.out.print("FE (Max 60): ");
            double fe = sc.nextDouble();

            double totalMarks = ct + at + fe;
            double gradePoint = getGradePoint(totalMarks);

            totalGradePoints += gradePoint * credit;
            totalCredits += credit;

            creditTaken += credit;
            if (gradePoint > 0) creditEarned += credit; // Passed course
        }

        double cgpa = totalGradePoints / totalCredits;
        String finalGrade = getLetterGrade(cgpa);

        System.out.println("\n----------------------------");
        System.out.println("Student ID: " + studentId);
        System.out.println("Credit Taken: " + creditTaken);
        System.out.println("Credit Earned: " + creditEarned);
        System.out.printf("CGPA: %.2f\n", cgpa);
        System.out.println("Grade: " + finalGrade);
    }
}
