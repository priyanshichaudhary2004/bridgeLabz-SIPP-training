import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class LargeFileGenerator {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        String filePath = "largefile.dat";  
        int fileSizeInMB = 100;             
        int totalBytes = fileSizeInMB * 1024 * 1024;

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[4096]; 
            Random random = new Random();

            for (int i = 0; i < totalBytes / buffer.length; i++) {
                random.nextBytes(buffer);   
                fos.write(buffer);
            }
            System.out.println("largefile.dat (100MB) created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating largefile.dat : " + e.getMessage());
        }
    }
}
