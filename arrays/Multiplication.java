import java.util.*;
public class Multiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		int[] table = new int[10];
		for(int i=1;i<=table.length;i++) {
			table[i-1]=num *i;
		}
		System.out.println("Multiplication table of "+num+": ");
		for(int i =1;i<=10;i++) {
			System.out.println(num + " * " + i + " = " +table[i-1] );
		}
		}

}
