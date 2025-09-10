import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputFromConsole {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = "", age = "", language = "";

        try {
            System.out.print("Enter your name : ");
            name = reader.readLine();

            System.out.print("Enter your age : ");
            age = reader.readLine();

            System.out.print("Enter your favorite programming language : ");
            language = reader.readLine();

            // Write to file
            FileWriter writer = new FileWriter("user_info.txt");
            writer.write("Name : " + name + "\n");
            writer.write("Age : " + age + "\n");
            writer.write("Favorite Language : " + language + "\n");

            writer.close();
            System.out.println("Data successfully written to user_info.txt");
        } catch (IOException e) {
            System.out.println("An error occurred : " + e.getMessage());
        }
    }
}
