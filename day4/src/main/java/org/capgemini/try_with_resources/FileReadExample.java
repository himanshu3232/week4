package org.capgemini.try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {
    public static void main(String[] args) {
        // Using try-with-resources to ensure automatic resource closing
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/info.txt"))) {
            // Read and print the first line of the file
            String firstLine = reader.readLine();
            System.out.println(firstLine != null ? firstLine : "File is empty");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}

