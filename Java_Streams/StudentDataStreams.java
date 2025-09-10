import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class StudentDataStreams {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        String fileName = "students.dat";
        Scanner sc = new Scanner(System.in);

        // Writing student data to binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            System.out.print("Enter number of students : ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for Student " + (i + 1));
                System.out.print("Roll Number : ");
                int roll = sc.nextInt();
                sc.nextLine();
                System.out.print("Name : ");
                String name = sc.nextLine();
                System.out.print("GPA : ");
                float gpa = sc.nextFloat();
                sc.nextLine();

                // Write to file
                dos.writeInt(roll);
                dos.writeUTF(name);
                dos.writeFloat(gpa);
            }

            System.out.println("\nStudent details have been saved to '" + fileName + "'");

        } catch (IOException e) {
            System.out.println("IOException during writing : " + e.getMessage());
        }

        // Reading student data from binary file
        System.out.println("\nReading student data from file : ");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int i = 1;
            while (true) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                float gpa = dis.readFloat();

                System.out.println("Student " + i + " → Roll : " + roll + "; Name : " + name + "; GPA : " + gpa);
                i++;
            }
        } catch (EOFException e) {
            System.out.println("\nAll student records retrieved successfully.");
        } catch (IOException e) {
            System.out.println("IOException during reading : " + e.getMessage());
        }
    }
}
