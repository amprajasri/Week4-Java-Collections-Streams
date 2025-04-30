import java.io.*;

public class ErrorLineReader {
    public static void main(String[] args) {
        String fileName = "C:\\JavaProjects\\day-19\\src\\largefile.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
