import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeSalaryCategorization {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("Name : ");
            String name = sc.nextLine();

            System.out.print("Department : ");
            String dept = sc.nextLine();

            System.out.print("Salary : ");
            double salary = sc.nextDouble();
            sc.nextLine(); 

            employees.add(new Employee(name, dept, salary));
        }

        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("\nAverage Salary by Department : ");
        avgSalaryByDept.forEach((dept, avg) ->
                System.out.println(dept + " -> " + avg));
    }
}