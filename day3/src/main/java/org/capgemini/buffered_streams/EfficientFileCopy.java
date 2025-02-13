package org.capgemini.buffered_streams;

import java.io.*;

/**
 * This program copies a file using both unbuffered and buffered streams.
 * It measures and compares execution time  for efficiency analysis.
 */
public class EfficientFileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt"; // Source file name
        String destinationFile = "destination.txt"; // Destination file name

        long startTime, endTime;

        // Unbuffered Stream Copy
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            startTime = System.nanoTime(); // Start time measurement
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            endTime = System.nanoTime(); // End time measurement

            System.out.println("Unbuffered Copy Time: " + (endTime - startTime) / 1e6 + " ms");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file does not exist.");
        } catch (IOException e) {
            System.out.println("Error: An IOException occurred - " + e.getMessage());
        }

        // Buffered Stream Copy for Efficiency
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            startTime = System.nanoTime(); // Start time measurement
            byte[] buffer = new byte[4096]; // 4 KB buffer for efficient copying
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            endTime = System.nanoTime(); // End time measurement

            System.out.println("Buffered Copy Time: " + (endTime - startTime) / 1e6 + " ms");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file does not exist.");
        } catch (IOException e) {
            System.out.println("Error: An IOException occurred - " + e.getMessage());
        }
    }
}

