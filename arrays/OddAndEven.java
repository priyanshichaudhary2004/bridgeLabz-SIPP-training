import java.util.*;
public class OddAndEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n =sc.nextInt();
		if(n<=0) {
			System.out.println("Error ");
			return;
		}
		int size = n/2 +1;
		int [] odd = new int[size];
		int []even = new int[size];
		int oddIndex = 0;
		int evenIndex =0;
		for(int i =1 ;i<=n;i++) {
			if(i%2 ==0) {
				even[evenIndex]=i;
				evenIndex++;
			}
			else {
				odd[oddIndex]=i;
				oddIndex++;
			}
		}
		System.out.println(" Odd numbers:");
		for(int i =0;i<oddIndex;i++) {
			System.out.println(odd[i]+" ");
		}
		System.out.println("Even numbers:");
		for(int i =0;i<evenIndex;i++) {
			System.out.println(even[i]+" ");
		}
	}

}
