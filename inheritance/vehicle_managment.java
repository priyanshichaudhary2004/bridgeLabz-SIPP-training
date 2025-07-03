package inheritance;


class Vehicle {
 String model;
 int maxSpeed;

 public Vehicle(String model, int maxSpeed) {
     this.model = model;
     this.maxSpeed = maxSpeed;
 }

 public void displayDetails() {
     System.out.println("Model: " + model);
     System.out.println("Max Speed: " + maxSpeed + " km/h");
 }
}

//Interface
interface Refuelable {
 void refuel();
}

//Subclass: ElectricVehicle
class ElectricVehicle extends Vehicle {
 int batteryCapacity; // in kWh

 public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
     super(model, maxSpeed);
     this.batteryCapacity = batteryCapacity;
 }

 public void charge() {
     System.out.println("Charging electric vehicle with " + batteryCapacity + " kWh battery.");
 }

 @Override
 public void displayDetails() {
     super.displayDetails();
     System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
 }
}


class PetrolVehicle extends Vehicle implements Refuelable {
 double fuelTankCapacity; // in liters

 public PetrolVehicle(String model, int maxSpeed, double fuelTankCapacity) {
     super(model, maxSpeed);
     this.fuelTankCapacity = fuelTankCapacity;
 }


 public void refuel() {
     System.out.println("Refueling petrol vehicle with " + fuelTankCapacity + " liters of petrol.");
 }


 public void displayDetails() {
     super.displayDetails();
     System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
 }
}

public class vehicle_managment {
	 public static void main(String[] args) {
	        ElectricVehicle tesla = new ElectricVehicle("Tesla Model 3", 200, 75);
	        PetrolVehicle honda = new PetrolVehicle("Honda City", 180, 40);

	        System.out.println("=== Electric Vehicle ===");
	        tesla.displayDetails();
	        tesla.charge();

	        System.out.println("\n=== Petrol Vehicle ===");
	        honda.displayDetails();
	        honda.refuel();
	    }
}
