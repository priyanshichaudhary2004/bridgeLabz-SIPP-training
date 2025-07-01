package java_class_and_obj;

public class student {
	String name;
	int rollNumber;
	int marks;
student(String name,int rollNumber,int marks){
	this.name=name;
	this.rollNumber=rollNumber;
	this.marks=marks;
	
	
}
public String CalculateGrade() {
	 if (marks >= 90) {
         return "A+";
     } else if (marks >= 80) {
         return "A";
     } else if (marks >= 70) {
         return "B";
     } else if (marks >= 60) {
         return "C";
     } else if (marks >= 50) {
         return "D";
     } else {
         return "F";
     }
}
public void displayInfo() {
	System.out.println("name is: "+name);
	System.out.println("rollNumber is: "+rollNumber);
	System.out.println("marks is: "+marks);
	System.out.println("grade is: "+CalculateGrade());
}
public static void main(String[]args) {
	student s1=new student ("harshit", 22, 90);
	s1.CalculateGrade();
	s1.displayInfo();
}
}
 