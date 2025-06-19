import java.util.*;
public class Multiplicationfrom6to9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num =sc.nextInt();
		int []arr =new int[4];
		int index =0;
		for(int i =6;i<=9;i++) {
			arr[index]=num*i;
			index++;
		}
		System.out.println("Multiplication results: ");
		index =0;
		for(int i =6;i<=9;i++) {
			System.out.println(num +" * "+i+ " = "+arr[index]);
			index++;
		}
		
	}

}
