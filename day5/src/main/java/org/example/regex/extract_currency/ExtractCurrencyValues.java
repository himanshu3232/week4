package org.example.extract_currency;

import java.util.*;
import java.util.regex.*;

public class ExtractCurrencyValues {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        List<String> currencyValues = extractCurrencyValues(text);
        System.out.println(String.join(", ", currencyValues));
    }

    public static List<String> extractCurrencyValues(String text) {
        String regex = "\\$?\\d+\\.\\d{2}"; // Matches optional "$" followed by a number with 2 decimal places
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> extractedValues = new ArrayList<>();
        while (matcher.find()) {
            extractedValues.add(matcher.group());
        }
        return extractedValues;
    }
}
