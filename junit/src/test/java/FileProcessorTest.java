import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {

    FileProcessor fileProcessor = new FileProcessor();
    String filename = "testfile.txt";
    String content = "Hello, JUnit!";

    // Test to check if content is written and read correctly
    @Test
    void testWriteAndReadFile() throws IOException {
        fileProcessor.writeToFile(filename, content);
        String readContent = fileProcessor.readFromFile(filename);
        assertEquals(content, readContent);
    }

    // Test to check if the file exists after writing
    @Test
    void testFileExistsAfterWriting() throws IOException {
        fileProcessor.writeToFile(filename, content);
        Path path = Paths.get(filename);
        assertTrue(Files.exists(path));
    }

    // Test to check handling of IOException when the file does not exist
    @Test
    void testIOExceptionWhenFileDoesNotExist() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistentfile.txt"));
    }

    // Cleanup: Delete the test file after each test
    @AfterEach
    void cleanup() throws IOException {
        Path path = Paths.get(filename);
        if (Files.exists(path)) {
            Files.delete(path);
        }
    }
}
