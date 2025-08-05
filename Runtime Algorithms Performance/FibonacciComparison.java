import java.util.Scanner;

public class FibonacciComparison {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        //Fibonacci number index
        System.out.print("Enter Fibonacci number : ");
        int n = sc.nextInt();

        System.out.println("\n--- Fibonacci Computation Comparison ---");

        // Recursive (O(2^n)) - Warning for large n
        if (n <= 40) {  // limit to avoid long runtime
            long startRec = System.nanoTime();
            int recResult = fibonacciRecursive(n);
            long endRec = System.nanoTime();
            System.out.println("Recursive Result : " + recResult);
            System.out.println("Recursive Time : " + formatTime(endRec - startRec));
        } else {
            System.out.println("Recursive Time : Skipped (Too slow for N > 40)");
        }

        // Iterative (O(N))
        long startItr = System.nanoTime();
        int itrResult = fibonacciIterative(n);
        long endItr = System.nanoTime();
        System.out.println("Iterative Result : " + itrResult);
        System.out.println("Iterative Time : " + formatTime(endItr - startItr));

        System.out.println("\nRecursive is infeasible for large N due to exponential calls.");
        System.out.println("Iterative is fast and memory-efficient.");
    }

    // Recursive Fibonacci (Exponential time)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear time)
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Format time in readable units
    private static String formatTime(long nanos) {
        long millis = nanos / 1_000_000;
        if (millis < 1) {
        	return nanos / 1_000 + " µs";
        } else if (millis < 1000) {
        	return millis + " ms";
        } else {
        	return String.format("%.2f s", millis / 1000.0);
        }
    }
}
