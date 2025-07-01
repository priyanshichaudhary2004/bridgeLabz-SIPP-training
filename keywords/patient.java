package key_words;

public class patient {


	    static String hospitalName = "City Care Hospital";
	    static int totalPatients = 0;

	    String name;
	    int age;
	    String ailment;
	    final int patientID;

	    static int nextID = 1;

	    public patient(String name, int age, String ailment) {
	        this.name = name;
	        this.age = age;
	        this.ailment = ailment;
	        this.patientID = nextID++;
	        totalPatients++;
	    }

	    public static void getTotalPatients() {
	        System.out.println("Total patients admitted: " + totalPatients);
	    }

	    public void displayDetails(Object obj) {
	        if (obj instanceof patient) {
	        	patient p = (patient) obj;
	            System.out.println("Hospital: " + hospitalName);
	            System.out.println("Patient ID: " + p.patientID);
	            System.out.println("Name: " + p.name);
	            System.out.println("Age: " + p.age);
	            System.out.println("Ailment: " + p.ailment);
	            
	        } else {
	            System.out.println("Invalid object. Not a Patient.");
	        }
	    }

	    public static void main(String[] args) {
	        patient p1 = new patient("Anjali", 30, "Fever");
	        patient p2 = new patient("Rohit", 45, "Diabetes");

	        p1.displayDetails(p1);
	        p2.displayDetails(p2);

	        patient.getTotalPatients();
	    }
	}


