package inheritance;


//Superclass
class Person {
 String name;
 int age;

 public Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public void displayDetails() {
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
 }

 public void displayRole() {
     System.out.println("Role: Generic Person");
 }
}

//Subclass: Teacher
class Teacher extends Person {
 String subject;

 public Teacher(String name, int age, String subject) {
     super(name, age);
     this.subject = subject;
 }

 @Override
 public void displayRole() {
     System.out.println("Role: Teacher");
 }

 @Override
 public void displayDetails() {
     super.displayDetails();
     System.out.println("Subject: " + subject);
 }
}

//Subclass: Student
class Student extends Person {
 String grade;

 public Student(String name, int age, String grade) {
     super(name, age);
     this.grade = grade;
 }

 @Override
 public void displayRole() {
     System.out.println("Role: Student");
 }

 
 public void displayDetails() {
     super.displayDetails();
     System.out.println("Grade: " + grade);
 }
}


class Staff extends Person {
 String department;

 public Staff(String name, int age, String department) {
     super(name, age);
     this.department = department;
 }


 public void displayRole() {
     System.out.println("Role: Staff");
 }

 
 public void displayDetails() {
     super.displayDetails();
     System.out.println("Department: " + department);
 }
}

public class school_system {
	public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student student = new Student("Priya", 16, "10th Grade");
        Staff staff = new Staff("Ravi", 35, "Administration");

        System.out.println("=== Teacher ===");
        teacher.displayRole();
        teacher.displayDetails();

        System.out.println("\n=== Student ===");
        student.displayRole();
        student.displayDetails();

        System.out.println("\n=== Staff ===");
        staff.displayRole();
        staff.displayDetails();
    }
}
