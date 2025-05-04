import java.io.*;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        String fileName = "info.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            System.out.println("First line: " + firstLine);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
