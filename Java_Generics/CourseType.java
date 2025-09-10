import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
	String courseName;

    CourseType(String courseName) {
        this.courseName = courseName;
    }

    abstract void displayEvaluation();
}

//ExamCourse Subclass
class ExamCourse extends CourseType {
	int examWeightage;

	ExamCourse(String courseName, int examWeightage) {
		super(courseName);
		this.examWeightage = examWeightage;
	}

	@Override
	void displayEvaluation() {
		System.out.println("Evaluation : \nExam Weightage = " + examWeightage);
	}
}

//AssignmentCourse Subclass
class AssignmentCourse extends CourseType {
	int assignmentCount;

	AssignmentCourse(String courseName, int assignmentCount) {
		super(courseName);
		this.assignmentCount = assignmentCount;
	}

	@Override
	void displayEvaluation() {
		System.out.println("Evaluation : \nNumber of Assignments = " + assignmentCount);
	}
}

//ResearchCourse Subclass
class ResearchCourse extends CourseType {
	String researchTopic;

	ResearchCourse(String courseName, String researchTopic) {
		super(courseName);
		this.researchTopic = researchTopic;
	}

	@Override
	void displayEvaluation() {
		System.out.println("Evaluation : \nResearch Topic = " + researchTopic);
	}
}

//Generic Class to manage different Course types
class Course<T extends CourseType> {
	private List<T> courseList = new ArrayList<>();

	public void addCourse(T course) {
		courseList.add(course);
	}

	public void displayCourses() {
		for (T course : courseList) {
			System.out.println("Course Name : " + course.courseName);
			course.displayEvaluation();
		}
	}

	// Use of Wildcards - Read-Only (Best Practice #3)
	public static void displayAllCourses(List<? extends CourseType> list) {
		for (CourseType course : list) {
			System.out.println("Course Name : " + course.courseName);
			course.displayEvaluation();
		}
	}
}
