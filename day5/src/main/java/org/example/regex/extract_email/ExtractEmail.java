package org.example.extract_email;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExtractEmail {
    public static void main(String[] args) {
        //prints the list of valid emails in the text
        System.out.println(extractEmailFromText("Contact us at support@example.com and info@company.org"));
    }

    //extracts emails from text
    private static List<String> extractEmailFromText(String text){
        String regex = "[a-zA-Z0-9_.+%-]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> results = new ArrayList<>();
        while (matcher.find()){
            results.add(matcher.group());
        }
        return results;
    }
}
