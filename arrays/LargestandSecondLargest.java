import java.util.Scanner;

public class LargestandSecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = new int[10];
        int index = 0;
        while (number != 0) {
            digits[index++] = number % 10;
            number = number / 10;
        }

        System.out.print("Digits extracted: ");
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(digits[i] + " ");
        }

        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < index; i++) {
            int d = digits[i];
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
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
