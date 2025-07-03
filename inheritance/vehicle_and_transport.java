package inheritance;
class vehicle{
	double maxspeed;
	String fueltype;
vehicle(double maxspeed,String fueltype){
	this.maxspeed=maxspeed;
	this.fueltype=fueltype;
	
}
void displayinfo() {
	System.out.println("maxspeed is: "+maxspeed+"km/hr");
	System.out.println("fueltype is: "+fueltype);
}
}

class car extends vehicle{
	int seatcapacity;
	car(double maxspeed,String fueltype,int seatcapacity){
		super(maxspeed,fueltype);
		this.seatcapacity=seatcapacity;
	}
	void displayinfo() {
		System.out.println("   ----   ");
		super.displayinfo();
		System.out.println("seat capacity is : " +seatcapacity);
	}		
	}

class truck extends vehicle{
	int loadcapacity;
	truck(double maxspeed,String fueltype,int loadcapacity){
		super(maxspeed,fueltype);
		this.loadcapacity=loadcapacity;
	}
	void displayinfo() {
		System.out.println("   ----   ");
		super.displayinfo();
		System.out.println("seat capacity is : " +loadcapacity);
	}
}

class motorcycle extends vehicle{
	
	motorcycle(double maxspeed,String fueltype){
		super(maxspeed,fueltype);
		
	}
	void displayinfo() {
		System.out.println("   ----   ");
		super.displayinfo();
		
	}
}

public class vehicle_and_transport {
	public static void main(String[]args) {
		vehicle[] vehicles=new vehicle[4];
		vehicles[0]=new car(100,"diesel",6);
		vehicles[1]=new truck(250,"petrol",600);
		vehicles[2]=new car(110,"diesel",3);
		vehicles[3]=new motorcycle(80,"petrol");
		vehicles[0]=new motorcycle(90,"petrol");
		for(vehicle v: vehicles) {
			v.displayinfo();
		}
		
	}
}
