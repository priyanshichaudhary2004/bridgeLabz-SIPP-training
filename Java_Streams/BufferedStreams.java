import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class BufferedStreams {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source file path : ");
        String sourcePath = sc.nextLine();

        System.out.print("Enter destination file path for unbuffered copy : ");
        String destPathUnbuffered = sc.nextLine();

        System.out.print("Enter destination file path for buffered copy : ");
        String destPathBuffered = sc.nextLine();

        final int BUFFER_SIZE = 4096;

        try (
            FileInputStream fis = new FileInputStream(sourcePath);
            FileOutputStream fos = new FileOutputStream(destPathUnbuffered);
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            long start = System.nanoTime();
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            long durationUnbuffered = (end - start) / 1_000_000;
            System.out.println("Unbuffered copy time : " + durationUnbuffered + " ms");
        } catch (IOException e) {
            System.out.println("Error in unbuffered copy : " + e.getMessage());
        }

        try (
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPathBuffered));
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            long start = System.nanoTime();
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            long durationBuffered = (end - start) / 1_000_000;
            System.out.println("Buffered copy time : " + durationBuffered + " ms");
        } catch (IOException e) {
            System.out.println("Error in buffered copy : " + e.getMessage());
        }
    }
}
