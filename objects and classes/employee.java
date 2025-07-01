package java_class_and_obj;

public class employee {
String name;
int id;
int salary;

employee(String name,int id,int salary){
	this.name=name;
	this.id=id;
	this.salary=salary;
	
}
public void displayInfo() {
	System.out.println("name is: "+name);
	System.out.println("id is: "+id);
	System.out.println("salary is: "+salary);
}
public static void main(String[]args) {
	employee e1=new employee("harshit", 22, 55000);
	e1.displayInfo();
}
}
