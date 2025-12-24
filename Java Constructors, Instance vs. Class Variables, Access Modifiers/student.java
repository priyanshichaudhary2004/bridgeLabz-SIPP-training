package oops;


class students{	
	public int rollNum;
	protected String name;
	private double CGPA;
	
	students(int rollNum, String name,double CGPA){
		this.rollNum=rollNum;
		this.name=name;
		this.CGPA=CGPA;
	}
	public double getCGPA() {
		return CGPA;
	} 
	public void setCGPA(double CGPA) {
		this.CGPA=CGPA;
	}
	public  void displayInfo() {
		System.out.println("roll number is: "+ rollNum);
		System.out.println("name is: "+name);
		System.out.println("CGPA is: "+CGPA);
		
	}
}



class PostgraduateStudent extends students{
	private String projectName;
	
	public  PostgraduateStudent(int rollNum, String name, double CGPA,String projectName) {
		super(rollNum,name,CGPA);
		this.projectName=projectName; 
	}
	public void displayPostgraduateStudentinfo() {
		System.out.println("project name is: "+ projectName);
		System.out.println("name is: "+name);
	}
}
	
	 class student {
	public static void main(String[]args) {
		students s1=new students(24,"akshat",7.9);
		
		s1.displayInfo();
		
	//update
		s1.setCGPA(9.0);
		PostgraduateStudent p1= new PostgraduateStudent(21,"ram",8.5,"machine learning");
		p1.displayInfo();
		p1.displayPostgraduateStudentinfo();
	}
}

