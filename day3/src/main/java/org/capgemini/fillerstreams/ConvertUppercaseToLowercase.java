package org.capgemini.fillerstreams;

import java.io.*;

public class ConvertUppercaseToLowercase {

    // Method to convert uppercase letters to lowercase while copying file
    public static void convertFileToLowerCase(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File conversion successful. Output saved to: " + outputFile);

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "input.txt";  // Change to your actual file path
        String outputFilePath = "output.txt"; // Change to desired output path

        convertFileToLowerCase(inputFilePath, outputFilePath);
    }
}
