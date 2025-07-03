package inheritance;

class device{
	String deviceId;
    String status;  // e.g., "ON", "OFF"

    device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}
class Thermostat extends device {
    double temperatureSetting;

    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status); 
        this.temperatureSetting = temperatureSetting;
    }
 
    void displayStatus() {
        super.displayStatus();  
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
        System.out.println("Device Type: Thermostat");
    }
}


public class smart_home {
	   public static void main(String[] args) {
	        Thermostat t1 = new Thermostat("T001", "ON", 22.5);
	        t1.displayStatus();
	    }
}
