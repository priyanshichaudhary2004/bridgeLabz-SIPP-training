import java.util.*;

public class StudentGrade_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Student " + (i + 1));

            System.out.print("Physics: ");
            int p = sc.nextInt();
            if (p < 0) { 
            	System.out.println("Invalid marks!");
            	i--;
            	continue;
            	}

            System.out.print("Chemistry: ");
            int c = sc.nextInt();
            if (c < 0) { 
            	System.out.println("Invalid marks!");
            	i--;
            	continue; 
            	}

            System.out.print("Maths: ");
            int m = sc.nextInt();
            if (m < 0) {
            	System.out.println("Invalid marks!"); 
            	i--; 
            	continue;
            	}

            
            physics[i] = p;
            chemistry[i] = c;
            maths[i] = m;
        }

        for (int i = 0; i < n; i++) {
            int total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90) grade[i] = "A";
            else if (percentage[i] >= 75) grade[i] = "B";
            else if (percentage[i] >= 60) grade[i] = "C";
            else if (percentage[i] >= 40) grade[i] = "D";
            else grade[i] = "F";
        }

        System.out.println("Student Results:");
        System.out.println("Stu  Physics  Chemistry  Maths  %      Grade");

        for (int i = 0; i < n; i++) {
            System.out.println(
                              (i + 1)+ physics[i]+chemistry[i]+ maths[i]+ percentage[i]+ grade[i]);
        }
    }
}
