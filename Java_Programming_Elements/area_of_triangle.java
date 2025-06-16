import java.util.*;
public class area_of_triangle {
public static void main(String[]args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the base: ");
		float base=sc.nextFloat();
		System.out.println("enter the height: ");
		float height=sc.nextFloat();
		float area=(1/2)*base*height;
		System.out.println("area is: "+ area);
	}

}
