import java.util.Scanner;

public class EuclideanDistance {

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[]{m, b};
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance : " + distance);

        double[] result = findLineEquation(x1, y1, x2, y2);
        System.out.println("Slope (m) : " + result[0]);
        System.out.println("Y-Intercept (b) : " + result[1]);
        System.out.println("Equation of Line : y = " + result[0] + " x + " + result[1]);
    }
}
