import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SearchComparison {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter dataset size : ");
        int n = sc.nextInt();

        System.out.print("Enter element to search : ");
        int target = sc.nextInt();

        int[] dataset = new int[n];

        // Fill dataset with random integers
        for (int i = 0; i < n; i++) {
            dataset[i] = ThreadLocalRandom.current().nextInt(1, n * 10);
        }

        // Sort the dataset for binary search
        Arrays.sort(dataset);

        // If target = -1, pick a guaranteed present element from dataset
        if (target == -1) {
            target = dataset[n / 2];
        } else {
            //Check if target is present; if not, forcibly insert
            if (Arrays.binarySearch(dataset, target) < 0) {
                dataset[0] = target;  
                Arrays.sort(dataset);
            }
        }

        System.out.println("\nSearching for : " + target);

        // Linear Search
        long startLinear = System.nanoTime();
        boolean foundLinear = linearSearch(dataset, target);
        long endLinear = System.nanoTime();

        // Binary Search
        long startBinary = System.nanoTime();
        int foundIndex = Arrays.binarySearch(dataset, target);
        boolean foundBinary = foundIndex >= 0;
        long endBinary = System.nanoTime();

        System.out.println("\n--- Search Performance ---");
        System.out.println("Linear Search (O(N)) : " + formatTime(endLinear - startLinear) + " | Found : " + foundLinear);
        System.out.println("Binary Search (O(log N)) : " + formatTime(endBinary - startBinary) + " | Found : " + foundBinary);

        sc.close();
    }

    // Linear search implementation
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    // Format nano seconds to readable string
    public static String formatTime(long nanos) {
        long micros = nanos / 1_000;
        if (micros < 1000) {
        	return micros + " µs";
        } else {
        	return String.format("%.3f ms", micros / 1000.0);
        }
    }
}
