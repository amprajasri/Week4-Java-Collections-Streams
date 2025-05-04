import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileProcessor {

    // Method to write content to a file
    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            writer.write(content);
        }
    }

    // Method to read content from a file
    public String readFromFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        if (!Files.exists(path)) {
            throw new IOException("File does not exist");
        }
        return new String(Files.readAllBytes(path));
    }
}
