package key_words;

public class employee {
	static String companyName="Wipro";
	String name;
	String designation;
	final int id;
	static int Totalemployees=0;
employee(String name,String designation,int id){
	this.name=name;
	this.designation=designation;
	this.id=id;
	Totalemployees++;
}
	
	public static void displayTotalEmployees() {
		System.out.println("total employee is"+ Totalemployees);
	}
	public void employeeDetails(employee obj) {
		System.out.println("employee name is: "+obj.name);
		System.out.println("employee designation is: "+obj.designation);
		System.out.println("employee id is: "+obj.id);
		
	}
	
	public static void main(String[]args) {
		employee e1= new employee("aashi","data analyst",22);
		employee e2= new employee("ishu","data analyst",22);
		displayTotalEmployees();
		e1.employeeDetails(e1);
		e2.employeeDetails(e2);
		
	}
}
