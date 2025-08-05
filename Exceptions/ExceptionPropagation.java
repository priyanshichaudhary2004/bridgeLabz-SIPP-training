import java.util.Scanner;

public class ExceptionPropagation {

    // method1(): Takes two numbers and performs division (user input)
    public static void method1(int a, int b) {
        int result = a / b; 
        System.out.println("Result : " + result);
    }

    // method2(): Calls method1()
    public static void method2(int a, int b) {
        method1(a, b); 
    }

    // main(): calls method2(), and handles exception
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numerator : ");
        int num = sc.nextInt();

        System.out.print("Enter denominator : ");
        int den = sc.nextInt();

        try {
            method2(num, den); 
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
