import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;

public class SlidingWindowMaximum {
	public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i = 0; i < nums.length; i++) {
			if(!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			
			//Remove smaller elemets as they won't be needed
			while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			
			//Add current index
			deque.offerLast(i);
			
			if(i >= k - 1) {
				result.add(nums[deque.peekFirst()]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size of array : ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.print("Enter array elements : ");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print("Enter window size k : ");
		int k = sc.nextInt();
		
		ArrayList<Integer> result = maxSlidingWindow(arr, k);
		System.out.println("Slinding Window Maximums : ");
		for(int val : result) {
			System.out.println(val + " ");
		}
	}
}
