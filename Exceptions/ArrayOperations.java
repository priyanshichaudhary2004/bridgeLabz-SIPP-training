import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        Integer[] arr = null;

        try {
            System.out.print("Enter the size of the array : ");
            int size = sc.nextInt();

            if (size <= 0) {
                System.out.println("Array is not initialized!");
                return;
            }

            arr = new Integer[size];

            System.out.println("Enter " + size + " integer elements : ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.print("Enter the index to access : ");
            int index = sc.nextInt();

            System.out.println("Value at index " + index + " : " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
