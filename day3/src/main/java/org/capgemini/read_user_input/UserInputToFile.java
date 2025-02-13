package org.capgemini.read_user_input;

import java.io.*;

/**
 * This program reads user input from the console and saves it into a file.
 * It uses BufferedReader for input and FileWriter for file output.
 */
public class UserInputToFile {
    public static void main(String[] args) {
        String outputFile = "user_data.txt"; // File to save user input

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(outputFile)) {

            // Read user input
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Write data to file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("User data has been saved successfully to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error: An IOException occurred - " + e.getMessage());
        }
    }
}

