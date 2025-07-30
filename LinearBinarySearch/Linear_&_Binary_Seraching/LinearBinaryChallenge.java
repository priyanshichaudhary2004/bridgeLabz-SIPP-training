import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class LinearBinaryChallenge {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the size of the list : ");
            int size = Integer.parseInt(br.readLine());

            int[] arr = new int[size];
            System.out.println("Enter " + size + " integers (positive/negative/zero) : ");
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int[] arrForBinarySearch = Arrays.copyOf(arr, arr.length);

            int missing = findFirstMissingPositive(arr);
            System.out.println("First missing positive integer : " + missing);

            System.out.print("Enter the target number for Binary Search : ");
            int target = Integer.parseInt(br.readLine());

            Arrays.sort(arrForBinarySearch);
            int index = binarySearch(arrForBinarySearch, target);

            if (index != -1) {
                System.out.println("Target " + target + " found at index (in sorted array) : " + index);
            } else {
                System.out.println("Target " + target + " not found in the list.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
	}
}
