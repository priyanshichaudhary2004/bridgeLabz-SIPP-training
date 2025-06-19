import java.util.*;
public class Reversenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		if(n<=0) {
			System.out.println("Enter positive number.");
			return;
		}
		int temp=n;
		int count =0;
		while(temp>0) {
			temp/=10;
			count++;
		}
		int[] digit = new int[count];
		temp=n;
		for(int i =count-1;i>=0;i--) {
			digit[i]=temp%10;
			temp/=10;
		}
		int[] reverse = new int[count];
		for(int i =0;i<count;i++) {
			reverse[i]= digit[count-1-i];
		}
		System.out.print("Reversed number: ");
        for (int digits : reverse) {
            System.out.print(digits);
        }

	}

}
