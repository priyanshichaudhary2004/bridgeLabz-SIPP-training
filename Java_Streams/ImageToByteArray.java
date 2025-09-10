import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ImageToByteArray {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        String inputImagePath = "original.jpg";     
        String outputImagePath = "copy.jpg";        

        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get(inputImagePath));

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(imageBytes);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

            FileOutputStream fos = new FileOutputStream(outputImagePath);
            int data;
            while ((data = bais.read()) != -1) {
                fos.write(data);
            }

            bais.close();
            baos.close();
            fos.close();

            boolean isEqual = Files.mismatch(Paths.get(inputImagePath), Paths.get(outputImagePath)) == -1;
            if (isEqual) {
                System.out.println("New image is identical to the original image.");
            } else {
                System.out.println("New image is NOT identical to the original image.");
            }

        } catch (IOException e) {
            System.out.println("IOException occurred : " + e.getMessage());
        }
    }
}
