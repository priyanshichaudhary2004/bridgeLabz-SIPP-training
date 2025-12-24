package key_words;

public class student {
	static String universityName="GLA University";
	String name;
	final int rollNumber;
	char grade;
	static int TotalStudents=0;
	
student(String name, int rollNumber, char grade){
	this.name=name;
	this.rollNumber=rollNumber;
	this.grade=grade;
	TotalStudents++;
}
public static void displayTotalStudents()
{
	System.out.println("total student is"+ TotalStudents);
	}
public void displayDetail(Object obj) {
	if(obj instanceof student) {
		System.out.println("student name is: "+name);
		System.out.println("student rollnumber is: "+rollNumber);
		System.out.println("student garde is: "+grade);
		
	}else {
		System.out.println("not a valid student detail");
	}
}
public static void main(String[]args) {
	student s1= new student("aashi",22,'A');
	
	displayTotalStudents();
	
	s1.displayDetail(s1);
	
}
}
