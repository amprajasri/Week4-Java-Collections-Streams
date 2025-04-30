import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInputToFile {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name, age, language;

        try {
            System.out.print("Enter your name: ");
            name = reader.readLine();

            System.out.print("Enter your age: ");
            age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            language = reader.readLine();

            try (FileWriter writer = new FileWriter("userInfo.txt")) {
                writer.write("Name: " + name + "\n");
                writer.write("Age: " + age + "\n");
                writer.write("Favorite Programming Language: " + language + "\n");
                System.out.println("User information saved to file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
