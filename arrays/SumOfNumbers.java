import java.util.*;
public class SumOfNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		double []arr = new double[10];
		double total =0.0;
		int index =0;
		while(true) {
		   double num = sc.nextDouble();
			if(num<=0) {
				break;
			}
			if(index == arr.length) {
				System.out.println("Array limit reached(10 elements)");
				break;
			}
			arr[index]=num;
			index++;
		}
		System.out.print("Numbers entered: ");
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
            total += arr[i];
        }
        System.out.println("Sum of all numbers: "+total);

	}

}
