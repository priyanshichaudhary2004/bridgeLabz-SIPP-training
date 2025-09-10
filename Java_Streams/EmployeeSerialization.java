import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID = " + id + "; Name = " + name + "; Department = " + department + "; Salary = " + salary + "]";
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	Scanner sc = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();

        System.out.print("Enter number of employees : ");
        int n = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Employee " + (i + 1));
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Name : ");
            String name = sc.nextLine();
            System.out.print("Department : ");
            String department = sc.nextLine();
            System.out.print("Salary : ");
            double salary = sc.nextDouble();
            sc.nextLine(); 

            employeeList.add(new Employee(id, name, department, salary));
        }

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
            oos.writeObject(employeeList);
            System.out.println("\nEmployees have been serialized to employees.ser file.");
        } catch (IOException e) {
            System.out.println("IOException occurred during serialization : " + e.getMessage());
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"))) {
            List<Employee> deserializedList = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employees : ");
            for (Employee emp : deserializedList) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            System.out.println("IOException occurred during deserialization : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException : " + e.getMessage());
        }
    }
}
