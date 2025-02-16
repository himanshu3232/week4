package basic;

import org.example.junit.basic.FileProcessor;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {
    private static final String TEST_FILE = "testFile.txt";

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, JUnit!";
        FileProcessor.writeToFile(TEST_FILE, content);
        assertEquals(content, FileProcessor.readFromFile(TEST_FILE), "File content should match");
    }

    @Test
    void testFileExistsAfterWriting() throws IOException {
        FileProcessor.writeToFile(TEST_FILE, "Sample content");
        File file = new File(TEST_FILE);
        assertTrue(file.exists(), "File should exist after writing");
    }

    @Test
    void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonExistent.txt"), "Should throw IOException for non-existent file");
    }
}

