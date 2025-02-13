package org.capgemini.read_large_file;

import java.io.*;

public class LargeFileReader {
    public static void readLargeFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "large_log.txt"; // Update with actual file path
        readLargeFile(filePath);
    }
}
