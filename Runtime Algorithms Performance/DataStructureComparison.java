import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DataStructureComparison {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter dataset size : ");
        int n = sc.nextInt();

        System.out.print("Enter element to search : ");
        int searchTarget = sc.nextInt();

        System.out.println("\n--- Initializing Data Structures ---");

        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Fill with random integers
        for (int i = 0; i < n; i++) {
            int num = ThreadLocalRandom.current().nextInt(1, n * 10);
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        // Pick random present element if -1
        if (searchTarget == -1) {
            searchTarget = array[n / 2];  
        } else {
        	if(!hashSet.contains(searchTarget)) {
        		array[0] = searchTarget;
        		hashSet.add(searchTarget);
        		treeSet.add(searchTarget);
        	}
        }

        System.out.println("Searching for : " + searchTarget);
        System.out.println("\n--- Search Performance ---");

        //Array Search (O(N))
        long startArray = System.nanoTime();
        boolean foundInArray = linearSearch(array, searchTarget);
        long endArray = System.nanoTime();
        System.out.println("Array Search (O(N)) : " + formatTime(endArray - startArray) + " | Found : " + foundInArray);

        //HashSet Search (O(1))
        long startHash = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(searchTarget);
        long endHash = System.nanoTime();
        System.out.println("HashSet Search (O(1)) : " + formatTime(endHash - startHash) + " | Found : " + foundInHashSet);

        //TreeSet Search (O(log N))
        long startTree = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(searchTarget);
        long endTree = System.nanoTime();
        System.out.println("TreeSet Search (O(log N)) : " + formatTime(endTree - startTree) + " | Found : " + foundInTreeSet);

        System.out.println("\nHashSet is fastest for lookups but uses more memory.");
        System.out.println("TreeSet keeps sorted order but is slightly slower.");
        System.out.println("Array is simple but slow for large datasets.");
    }

    // Linear search for array
    private static boolean linearSearch(int[] arr, int key) {
        for (int val : arr) {
            if (val == key) return true;
        }
        return false;
    }

    // Format time to readable string
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
