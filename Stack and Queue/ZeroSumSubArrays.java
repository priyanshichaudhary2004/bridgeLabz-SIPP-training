import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ZeroSumSubArrays {
	//Method to find all subarrays with zero sums
	public static void findZeroSumSubArrays(int[] arr) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int sum  = 0;
		
		//To handle the case when subarray starts from index 0
		map.put(0, new ArrayList<>());
		map.get(0).add(-1);
		
		System.out.println("Subarrays with zero sum : ");
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
			if(map.containsKey(sum)) {
				for(int start : map.get(sum)) {
					System.out.println("From index " + (start + 1) + " to " + i);
				}
			}
			map.putIfAbsent(sum, new ArrayList<>());
			map.get(sum).add(i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of elements : ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Enter elements : ");
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		findZeroSumSubArrays(arr);
	}

}
