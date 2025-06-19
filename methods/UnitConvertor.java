public class UnitConvertor {
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        System.out.println("Kilometers to Miles : " + convertKmToMiles(5));
        System.out.println("Miles to Kilometers : " + convertMilesToKm(3.1));
        System.out.println("Meters to Feet : " + convertMetersToFeet(10));
        System.out.println("Feet to Meters : " + convertFeetToMeters(32.8));
    }
}
