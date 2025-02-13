package org.capgemini.byte_array_stream;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageByteArrayStream {

    // Method to convert image file to byte array
    public static byte[] imageToByteArray(String imagePath) {
        try {
            File file = new File(imagePath);
            return Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            System.err.println("Error reading image file: " + e.getMessage());
            return new byte[0];
        }
    }

    // Method to write byte array back to an image file
    public static void byteArrayToImage(byte[] imageData, String outputPath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Image successfully written to: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error writing image file: " + e.getMessage());
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        String inputImagePath = "input.jpg";  // Change to your image path
        String outputImagePath = "output.jpg"; // Output file path

        // Convert image to byte array
        byte[] imageData = imageToByteArray(inputImagePath);

        if (imageData.length > 0) {
            // Write byte array back to image
            byteArrayToImage(imageData, outputImagePath);

            // Verify files are identical
            try {
                boolean isIdentical = Arrays.equals(Files.readAllBytes(new File(inputImagePath).toPath()),
                        Files.readAllBytes(new File(outputImagePath).toPath()));
                System.out.println("Files are identical: " + isIdentical);
            } catch (IOException e) {
                System.err.println("Error verifying files: " + e.getMessage());
            }
        }
    }
}
