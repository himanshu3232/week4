package org.example.extract_programming_languages;

import java.util.*;
import java.util.regex.*;

public class ExtractProgrammingLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        List<String> languages = extractLanguages(text);
        System.out.println(String.join(", ", languages));
    }

    public static List<String> extractLanguages(String text) {
        // List of common programming languages
        String[] languageList = {"Java", "Python", "JavaScript", "C", "C++", "C#", "Go", "Swift", "Kotlin", "Ruby", "PHP", "R", "TypeScript", "Perl", "Rust", "Scala", "Dart"};

        List<String> extracted = new ArrayList<>();
        for (String lang : languageList) {
            String regex = "\\b" + Pattern.quote(lang) + "\\b"; // Ensure full word match
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                extracted.add(lang);
            }
        }
        return extracted;
    }
}

