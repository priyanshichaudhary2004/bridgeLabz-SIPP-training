package oops;

class employee{
	public int employeeID ;
	protected String department;
	private double salary ;
	employee(int employeeID ,String department, double salary ){
		this.employeeID=employeeID;
		this.department=department;
		this.salary=salary;
		
	}
	public double getsalary() {
		return salary;
	}
	public void setsalary(double salary) {
		this.salary=salary;
	}
	public void displayInfo() {
		System.out.println("emplyee id  is: "+employeeID);
		System.out.println("department name is: "+department);
		System.out.println("salary is: "+salary);
	}
	
}
class Manager extends employee{
	Manager(int employeeID, String department,double salary){
		super( employeeID,  department, salary);
		
	}public void displayInfomanager() {
		System.out.println("emplyee id  is: "+employeeID);
		System.out.println("department name is: "+department);
		System.out.println("salary is: "+getsalary());
	}
	
}

public class employeeRecords {
	public static void main(String[]args) {
		employee e1=new employee(22,"finance",55000);
		e1.displayInfo();
		Manager m1=new Manager(12,"funds",9000);
		m1.setsalary(90000);
		m1.displayInfomanager();
		
	}

}
