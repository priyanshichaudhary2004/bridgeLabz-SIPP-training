import java.util.Scanner;

public class PeakElementBinarySearch {
	
	public static int findPeakElement(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean leftIsSmaller = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean rightIsSmaller = (mid == n - 1 || arr[mid] > arr[mid + 1]);

            if (leftIsSmaller && rightIsSmaller) {
                return mid; 
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        return -1; 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element found at index : " + peakIndex);
        System.out.println("Peak element value : " + arr[peakIndex]);
	}
}
