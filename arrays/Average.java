import java.util.*;

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        
        int[][] marks = new int[n][3]; 
        double[] percentage = new double[n];
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1) + " (Physics, Chemistry, Maths):");
            for (int j = 0; j < 3; j++) {
                int mark = sc.nextInt();
                if (mark < 0) {
                    System.out.println("Marks cannot be negative. Re-enter all 3 marks for student " + (i + 1));
                    i--; 
                    break;
                } else {
                    marks[i][j] = mark;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += marks[i][j];
            }
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) {
                grades[i] = "A";
            } else if (percentage[i] >= 70) {
                grades[i] = "B";
            } else if (percentage[i] >= 60) {
                grades[i] = "C";
            } else if (percentage[i] >= 50) {
                grades[i] = "D";
            } else if (percentage[i] >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }

        
        System.out.println("\nStudent-wise Result:");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(marks[i][j] + "\t\t");
            }
            System.out.printf("%.2f\t\t%s\n", percentage[i], grades[i]);
        }

        sc.close();
    }
}
