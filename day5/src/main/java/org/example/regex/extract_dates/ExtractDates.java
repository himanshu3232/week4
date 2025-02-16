package org.example.extract_dates;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Extracts dates from texts and prints the result
public class ExtractDates {
    public static void main(String[] args) {
        System.out.println(extractDatesFromText("The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020."));
    }

    //extracts dates from text
    private static List<String> extractDatesFromText(String text) {
        String regex = "\\d{2}/\\d{2}/\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> result = new ArrayList<>();

        //finds and groups all the matches
        while(matcher.find())
            result.add(matcher.group());

        return result;
    }
}
