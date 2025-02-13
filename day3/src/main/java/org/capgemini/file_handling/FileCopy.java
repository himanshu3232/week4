package org.capgemini.file_handling;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt"; // Source file name
        String destinationFile = "destination.txt"; // Destination file name

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file does not exist.");
        } catch (IOException e) {
            System.out.println("Error: An IOException occurred - " + e.getMessage());
        }
    }
}
