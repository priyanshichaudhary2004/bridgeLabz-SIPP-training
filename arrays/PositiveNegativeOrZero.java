import java.util.*;
public class PositiveNegativeOrZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		int []arr = new int[5];
		for(int i =0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		
		if(arr[i]<0) {
			System.out.println("Number is negative");
		}
		else if (arr[i]==0) {
			System.out.println("Number is zero");
		}
		else {
			if(arr[i]% 2 ==0) {
				System.out.println("Number is positive even number");
			}
			else {
				System.out.println("Number is positive odd number");
			}
		}
		}
	}

}
