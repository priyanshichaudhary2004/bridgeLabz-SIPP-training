package key_words;

public class Vehicle {
	

	    static double registrationFee = 5000.0;

	   
	    String ownerName;
	    String vehicleType;
	    final String registrationNumber;
	    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
	        this.ownerName = ownerName;
	        this.vehicleType = vehicleType;
	        this.registrationNumber = registrationNumber;
	    }
	    public static void updateRegistrationFee(double newFee) {
	        registrationFee = newFee;
	        System.out.println("Registration fee updated to: ₹" + registrationFee);
	    }

	
	    public void displayDetails(Object obj) {
	        if (obj instanceof Vehicle) {
	            Vehicle v = (Vehicle) obj;
	            System.out.println("Owner Name: " + v.ownerName);
	            System.out.println("Vehicle Type: " + v.vehicleType);
	            System.out.println("Registration Number: " + v.registrationNumber);
	            System.out.println("Registration Fee: ₹" + registrationFee);
	           
	        } else {
	            System.out.println("Invalid Vehicle object.");
	        }
	    }

	
	    public static void main(String[] args) {
	        Vehicle v1 = new Vehicle("Priya", "Car", "MH12AB1234");
	        Vehicle v2 = new Vehicle("Ravi", "Bike", "UP32XY9988");
 
	        v1.displayDetails(v1);
	        v2.displayDetails(v2);

	        Vehicle.updateRegistrationFee(6500.0);

	        v1.displayDetails(v1);
	    }
	}


