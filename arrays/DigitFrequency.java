import java.util.*;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int[] digits = new int[10];
        int index = 0;
        while (number != 0 && index < 10) {
            digits[index++] = number % 10;
            number /= 10;
        }
        int[] freq = new int[10];
        for (int i = 0; i < index; i++) {
            freq[digits[i]]++;
        }
        System.out.println("Digit frequencies:");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println("Digit " + i + ": " + freq[i] + " times");
            }
        }
    }
}
