import java.util.List;

abstract class JobRole {
	protected String name;
    protected int experience;

    JobRole(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public abstract void printRoleInfo();
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer(String name, int experience) {
        super(name, experience);
    }

    @Override
    public void printRoleInfo() {
        System.out.println("Software Engineer Resume : ");
        System.out.println("Name : " + name + ", Experience : " + experience + " years");
    }
}

class DataScientist extends JobRole {
    DataScientist(String name, int experience) {
        super(name, experience);
    }

    @Override
    public void printRoleInfo() {
        System.out.println("Data Scientist Resume : ");
        System.out.println("Name : " + name + ", Experience : " + experience + " years");
    }
}

class ProductManager extends JobRole {
    ProductManager(String name, int experience) {
        super(name, experience);
    }

    @Override
    public void printRoleInfo() {
        System.out.println("Product Manager Resume : ");
        System.out.println("Name : " + name + ", Experience : " + experience + " years");
    }
}

public class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void display() {
        jobRole.printRoleInfo();
    }

    public static <T extends JobRole> Resume<T> createResume(T role) {
        return new Resume<>(role);
    }
}

class ResumeProcessor {
    public static void processResumes(List<? extends JobRole> roles) {
        System.out.println("\n--- Screening Resumes ---");
        for (JobRole role : roles) {
            role.printRoleInfo();
        }
    }
}