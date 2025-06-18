package control_flow_statments;
import java.util.*;
public class sumuntilzero_double {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0;

        while (true) {
            System.out.print("Enter a number (enter 0 to stop): ");
            double num = sc.nextDouble();

            if (num == 0) {
                break;
            }
            total+=num;

      }
        System.out.println("Total sum: " + total);
}
}