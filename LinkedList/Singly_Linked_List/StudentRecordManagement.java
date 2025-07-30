import java.util.Scanner;

class Student {
	int rollNo;
	String name;
	int age;
	char grade;
	Student next;
	
	//Constructor 
	Student(int rollNo, String name, int age, char grade) {
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.next = next;
	}
}

class StudentList {
	Student head = null;
	
	//Method for adding at beginning
	void addAtBeginning(Student newStudent) {
		newStudent.next = head;
		head = newStudent;
	}
	
	//Add at end
	void addAtEnd(Student newStudent) {
		if(head == null) {
			head = newStudent;
			return;
		}
		Student temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newStudent;
	}
	
	//Add at specific position
	void addAtPosition(Student newStudent, int position) {
		if(position <= 1 || head == null) {
			addAtBeginning(newStudent);
			return;
		}
		Student temp = head;
		for(int i = 1; i < position - 1 && temp.next != null; i++) {
			temp = temp.next;
		}
		newStudent.next = temp.next;
		temp.next = newStudent;
	}
	
	//Delete by roll number
	void deleteByRollNo(int rollNo) {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		if(head.rollNo == rollNo) {
			head = head.next;
			System.out.println("Record seleted.");
			return;
		}
		Student temp = head;
		while(temp.next != null && temp.next.rollNo != rollNo) {
			temp = temp.next;
		}
		if(temp.next == null) {
			System.out.println("Roll number not found.");
		} else {
			temp.next = temp.next.next;
			System.out.println("Record deleted.");
		}
	}
	
	//Search by roll number
	void searchByRollNo(int rollNo) {
		Student temp = head;
		while(temp != null) {
			if(temp.rollNo == rollNo) {
				System.out.println("Student Found : " + temp.rollNo + " , " + temp.name + " , " + temp.age + " , " + temp.grade);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student with Roll Number " + rollNo + " not found.");
	}
	
	//Display all records
	void displayAll() {
		if(head == null) {
			System.out.println("No records to display.");
			return;
		}
		Student temp = head;
		System.out.println("Student Records : ");
		while(temp != null) {
			System.out.println("Roll No : " + temp.rollNo + " , Name : " + temp.name + " , Age : " + temp.age + " , Grade : " + temp.grade);
			temp = temp.next;
		}
	}
	
	//Update grade by roll number
	void updateGrade(int rollNo, char newGrade) {
		Student temp = head;
		while(temp != null) {
			if(temp.rollNo == rollNo) {
				temp.grade = newGrade;
				System.out.println("Grade updated successfully.");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Roll Number not found.");
	}
}
public class StudentRecordManagement {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StudentList list = new StudentList();
		int choice;
		
		do {
            System.out.println("\nMenu : ");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Update Grade");
            System.out.println("6. Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();

            int rollNo, age, position;
            String name;
            char grade;

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No : ");
                    rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name : ");
                    name = sc.nextLine();
                    System.out.print("Enter Age : ");
                    age = sc.nextInt();
                    System.out.print("Enter Grade : ");
                    grade = sc.next().charAt(0);

                    Student newStudent = new Student(rollNo, name, age, grade);

                    System.out.println("1. Add at Beginning");
                    System.out.println("2. Add at End");
                    System.out.println("3. Add at Specific Position");
                    System.out.print("Enter position choice : ");
                    int posChoice = sc.nextInt();
                    switch (posChoice) {
                        case 1:
                            list.addAtBeginning(newStudent);
                            break;
                        case 2:
                            list.addAtEnd(newStudent);
                            break;
                        case 3:
                            System.out.print("Enter Position : ");
                            position = sc.nextInt();
                            list.addAtPosition(newStudent, position);
                            break;
                        default:
                            System.out.println("Invalid position choice.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll No to Delete : ");
                    rollNo = sc.nextInt();
                    list.deleteByRollNo(rollNo);
                    break;

                case 3:
                    System.out.print("Enter Roll No to Search : ");
                    rollNo = sc.nextInt();
                    list.searchByRollNo(rollNo);
                    break;

                case 4:
                    list.displayAll();
                    break;

                case 5:
                    System.out.print("Enter Roll No to Update Grade : ");
                    rollNo = sc.nextInt();
                    System.out.print("Enter New Grade : ");
                    grade = sc.next().charAt(0);
                    list.updateGrade(rollNo, grade);
                    break;

                case 6:
                    System.out.println("Exiting Program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
	}
}
