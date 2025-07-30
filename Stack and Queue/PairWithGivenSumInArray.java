import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class PairWithGivenSumInArray {
	//Function to check for a pair with the given sum
	public static boolean hasPairWithSum(int[] arr, int targetSum) {
		HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : arr) {
            int complement = targetSum - num;
            if (map.containsKey(complement)) {
                System.out.println("Pair found : (" + num + ", " + complement + ")");
                return true;
            }
            map.put(num, true);
        }

        return false;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number of elements in array : ");
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements :");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.print("Enter the target sum: ");
        int target = Integer.parseInt(br.readLine());

        boolean found = hasPairWithSum(arr, target);
        
        if (!found) {
            System.out.println("No pair found with the given sum.");
        }
	}

}
