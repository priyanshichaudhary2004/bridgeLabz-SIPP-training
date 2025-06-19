import java.util.*;

public class BMI_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));

            
            System.out.print("Enter weight (kg): ");
            double weight = sc.nextDouble();
            while (weight <= 0) {
                System.out.print("Enter positive weight: ");
                weight = sc.nextDouble();
            }

            System.out.print("Enter height (m): ");
            double height = sc.nextDouble();
            while (height <= 0) {
                System.out.print("Enter positive height: ");
                height = sc.nextDouble();
            }

            double bmi = weight / (height * height);
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            if (bmi < 18.5) weightStatus[i] = "Underweight";
            else if (bmi < 24.9) weightStatus[i] = "Normal";
            else if (bmi < 29.9) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        // Output
        System.out.println("Person\tWeight(kg)\tHeight(m)\tBMI\t\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.print((i + 1)+ personData[i][0]+personData[i][1]+ personData[i][2]+ weightStatus[i]);
        }
    }
}
