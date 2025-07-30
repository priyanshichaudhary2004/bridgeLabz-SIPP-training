import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class TwoSumArray {

    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }

        return new int[]{-1, -1}; // No valid pair found
    }

    public static void main(String[] args) throws IOException {
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number of elements : ");
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers :");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.print("Enter the target sum : ");
        int target = Integer.parseInt(br.readLine());

        int[] result = twoSum(arr, target);

        if (result[0] != -1) {
            System.out.println("Indices : (" + result[0] + ", " + result[1] + ")");
        } else {
            System.out.println("No two elements found with the given target sum.");
        }
    }
}
