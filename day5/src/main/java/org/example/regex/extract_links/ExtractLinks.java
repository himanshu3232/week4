package org.example.extract_links;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinks {
    public static void main(String[] args) {
        System.out.println(extractLinks("Visit https://www.google.com and http://example.org for more info."));
    }

    private static List<String> extractLinks(String text) {
        String regex = "http(s)?://(www\\.)?[-_.a-zA-Z0-9]+\\.[a-zA-Z]{2,5}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> links = new ArrayList<>();
        while(matcher.find())
            links.add(matcher.group());

        return links;
    }
}
