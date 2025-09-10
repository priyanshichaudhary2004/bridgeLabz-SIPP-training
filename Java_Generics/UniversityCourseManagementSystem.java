import java.util.Scanner;

public class UniversityCourseManagementSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Course<ExamCourse> examCourseManager = new Course<>();
        System.out.print("Enter number of Exam Courses : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Exam Course Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Exam Weightage : ");
            int weight = sc.nextInt();
            sc.nextLine();

            examCourseManager.addCourse(new ExamCourse(name, weight));
        }

        System.out.println("\n--- Displaying Exam-Based Courses ---");
        examCourseManager.displayCourses();
	}
}
