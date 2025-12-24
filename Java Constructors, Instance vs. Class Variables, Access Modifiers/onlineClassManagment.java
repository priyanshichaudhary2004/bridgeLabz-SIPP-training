package oops;

public class onlineClassManagment {
	String courseName;
	int duration;
	double fee;
	
	public static String instituteName;
	
	onlineClassManagment(String name,int duration,double fee){
		this.courseName=name;
		this.duration=duration;
		this.fee=fee;
	}
	
	public void displayCourseDetails() {
		System.out.println("cousre name is: "+courseName);
		System.out.println("duration is: "+duration);
		System.out.println("fee is: "+fee);
		
	}
	public static void updateInstituteName(String name) {
		instituteName=name;
		
	}
	
	public static void dispalyInstituteName() {
		System.out.println("institute name is: "+instituteName);
	}
		public static void main(String[]args) {
			updateInstituteName("GLA University");
			onlineClassManagment c1=new onlineClassManagment("science",4,1000000);
			onlineClassManagment c2=new onlineClassManagment("commerce",3,5000000);
			
			c1.displayCourseDetails();
			c2.displayCourseDetails();
			dispalyInstituteName();
			
			
			
		}
	}


