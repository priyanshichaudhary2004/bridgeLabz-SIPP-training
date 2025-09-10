import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class StudentResultGrouping {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name : ");
            String name = sc.nextLine();
            System.out.print("Enter grade level : ");
            String grade = sc.nextLine();
            students.add(new Student(name, grade));
        }

        Map<String, List<String>> grouped =
            students.stream()
                    .collect(Collectors.groupingBy(
                        Student::getGrade,   
                        Collectors.mapping(Student::getName, Collectors.toList()) 
                    ));

        System.out.println("\nGrouped Students by Grade:");
        grouped.forEach((grade, names) -> 
            System.out.println("Grade " + grade + " -> " + names));
    }
}