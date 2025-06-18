package control_flow_statments;
import java.util.Scanner;
public class multiplication_table {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        for(int i=6; i<=9;i++) {
        	System.out.println("multiplication table: "+ (number*i));
        }

}
}