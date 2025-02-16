package org.example.find_repeating_words;

import java.util.*;
import java.util.regex.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        Set<String> repeatingWords = findRepeatingWords(text);
        System.out.println(String.join(", ", repeatingWords));
    }

    public static Set<String> findRepeatingWords(String text) {
        String regex = "\\b(\\w+)\\b\\s+\\1\\b"; // Captures repeating words
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Set<String> repeatingWords = new HashSet<>();
        while (matcher.find()) {
            repeatingWords.add(matcher.group(1)); // Add the repeating word
        }
        return repeatingWords;
    }
}

