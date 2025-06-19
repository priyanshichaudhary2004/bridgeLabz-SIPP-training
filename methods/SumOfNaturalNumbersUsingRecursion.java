import java.util.Scanner;

public class SumOfNaturalNumbersUsingRecursion {

    public static int recursiveSum(int n) {
        if (n == 1)
            return 1;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number : ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input. Enter a natural number greater than 0.");
        } else {
            int sumRecursive = recursiveSum(n);
            int sumFormula = formulaSum(n);

            System.out.println("Sum using recursion : " + sumRecursive);
            System.out.println("Sum using formula : " + sumFormula);

            if (sumRecursive == sumFormula) {
                System.out.println("Both methods give the same result.");
            } else {
                System.out.println("Results do not match.");
            }
        }
    }
}
