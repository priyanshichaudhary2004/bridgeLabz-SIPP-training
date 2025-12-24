package inheritance;

class Employee{
	String name;
	int id;
	int salary;
Employee(String name, int id, int salary){
	this.name=name;
	this.id=id;
	this.salary=salary;
}
void displayDetails() {
	System.out.println("name is: "+name);
	System.out.println("id is: "+id);
	System.out.println("salary is: "+salary);
	
}

}
class manager extends Employee{
	int teamsize;
	manager(String name, int id, int salary,int teamsize){
		super(name,id,salary);
		this.teamsize=teamsize;
	}
	void displayDetails() {
		System.out.println("   ----   "); 
		super.displayDetails();
		System.out.println("team size is: "+teamsize);
		System.out.println("Role: manager ");
		
	}
}
class developer extends Employee{
	String programming_language;
	developer(String name, int id, int salary,String programming_language){
		super(name,id,salary);
		this.programming_language=programming_language;
	}

void displayDetails() {
	System.out.println("   ----   ");
	super.displayDetails();
	
	System.out.println("language is: "+programming_language);
	System.out.println("Role: developer ");
	
}
	
}
class intern extends Employee{
	int duration;
	intern(String name, int id, int salary, int duration){
		super(name,id,salary);
		this.duration=duration;
	}
	void displayDetails() {
		System.out.println("   ----   ");
		super.displayDetails();
		
		System.out.println("duration is: "+duration+"year");
		System.out.println("Role: intern ");
		
	}
}

public class employee_managment {
public static void main(String[]args) {
	Employee e1=new Employee("harshit",22,90000);
	e1.displayDetails();
	manager m1=new manager("nisha",98,7000,8);
	m1.displayDetails();
	developer d1=new developer("ishu",60,56780,"java");
	d1.displayDetails();
	intern i1=new intern("aashi",66,56780,2);
	i1.displayDetails();
}
}
