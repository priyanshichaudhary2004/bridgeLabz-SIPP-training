import java.util.Scanner;

public class NumberFormat {
    public static void generateException(String input) {
        int number = Integer.parseInt(input);
        System.out.println("Parsed number is : " + number);
    }

    public static void handleException(String input) {
        try {
            int number = Integer.parseInt(input);
            System.out.println("Parsed number in handler : " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException : Input is not a valid number!");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO Auto-generated method stub
        System.out.print("Enter a value : ");
        String userInput = scanner.nextLine();

        try {
            generateException(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Exception generated in generateException() : " + e);
        }

        handleException(userInput);
    }
}
