package inheritance;


class Person {
 String name;
 int id;

 public Person(String name, int id) {
     this.name = name;
     this.id = id;
 }

 public void displayDetails() {
     System.out.println("Name: " + name);
     System.out.println("ID: " + id);
 }
}

interface Worker {
 void performDuties();
}

//Subclass: Chef
class Chef extends Person implements Worker {
 String specialty;

 public Chef(String name, int id, String specialty) {
     super(name, id);
     this.specialty = specialty;
 }

 @Override
 public void performDuties() {
     System.out.println("Cooking delicious " + specialty + " dishes.");
 }

 public void displayDetails() {
     super.displayDetails();
     System.out.println("Specialty: " + specialty);
 }
}

class Waiter extends Person implements Worker {
 String shift;

 public Waiter(String name, int id, String shift) {
     super(name, id);
     this.shift = shift;
 }


 public void performDuties() {
     System.out.println("Serving food and attending customers during " + shift + " shift.");
 }

 public void displayDetails() {
     super.displayDetails();
     System.out.println("Shift: " + shift);
 }
}

public class restaurent {
	 public static void main(String[] args) {
	        Chef chef = new Chef("Anita", 101, "Italian");
	        Waiter waiter = new Waiter("Ravi", 201, "Evening");

	        System.out.println("=== Chef Details ===");
	        chef.displayDetails();
	        chef.performDuties();

	        System.out.println("\n=== Waiter Details ===");
	        waiter.displayDetails();
	        waiter.performDuties();
	    }
}
