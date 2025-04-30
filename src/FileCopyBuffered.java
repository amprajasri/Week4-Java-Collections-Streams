import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyBuffered {
    public static void main(String[] args) {
        String sourcePath = "C:\\JavaProjects\\day-19\\src\\source.txt";
        String destinationPath = "destinationBuffered.txt";
        long startTime, endTime;

        // Using Buffered Streams
        startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationPath))) {
            byte[] buffer = new byte[4096];
            int length;
            while ((length = bis.read(buffer)) > 0) {
                bos.write(buffer, 0, length);
            }
            System.out.println("Buffered File copied successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        endTime = System.nanoTime();
        System.out.println("Buffered Stream Time: " + (endTime - startTime) + " nanoseconds");

        // Using Unbuffered Streams
        String destinationPathUnbuffered = "destinationUnbuffered.txt";
        startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destinationPathUnbuffered)) {
            byte[] buffer = new byte[4096];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            System.out.println("Unbuffered File copied successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        endTime = System.nanoTime();
        System.out.println("Unbuffered Stream Time: " + (endTime - startTime) + " nanoseconds");
    }
}
