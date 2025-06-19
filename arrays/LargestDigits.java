import java.util.*;

public class LargestDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.println("Enter digits separated by space:");
        String input = sc.nextLine();

        String[] parts = input.split(" ");
        int[] digits = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            digits[i] = Integer.parseInt(parts[i]);
        }

        
        int largest = -1, secondLargest = -1;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }

        System.out.println("Largest digit: " + largest);
        if (secondLargest != -1) {
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("Second largest digit not found.");
        }
    }
}
