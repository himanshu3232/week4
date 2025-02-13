package org.capgemini.count_words;

import java.io.*;
import java.util.*;

public class LargeFileReader {
    public static void readLargeFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Map<String, Integer> wordCount = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            wordCount.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .limit(5)
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "large_log.txt"; // Update with actual file path
        readLargeFile(filePath);
    }
}