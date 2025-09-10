import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the source file path : ");
            String sourcePath = sc.nextLine();

            System.out.print("Enter the destination file path : ");
            String destinationPath = sc.nextLine();

            File sourceFile = new File(sourcePath);

            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationPath);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully.");

            fis.close();
            fos.close();

        } catch (IOException e) {
            System.out.println("An error occurred during file operation : " + e.getMessage());
        } finally {
        	sc.close();
        }
	}
}
