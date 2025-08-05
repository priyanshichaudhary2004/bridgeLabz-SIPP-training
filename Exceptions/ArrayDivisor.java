import java.util.Scanner;

public class ArrayDivisor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of the array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter " + size + " array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter index to access : ");
        int index = sc.nextInt();

        System.out.print("Enter divisor : ");
        int divisor = sc.nextInt();

        try {
            int element = arr[index];

            try {
                int result = element / divisor;
                System.out.println("Result : " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}
