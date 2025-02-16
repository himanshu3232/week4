package org.example.extract_capital_letters;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ExtractWordsWithCapitalLetters {
    public static List<String> extractWords(String text){
        //checks for capital letter at the beginning
        String regex = "^[A-Z].*";
        Pattern pattern = Pattern.compile(regex);
        //split the text based on spaces
        String[] words = text.trim().split("\\s+");
        //store result in a result list
        List<String> result = new ArrayList<>();
        for(String s : words){
            if(pattern.matcher(s).matches()){
                //remove other characters like .,?,+,-...
                String validResult = validateString(s);
                result.add(validResult);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(extractWords("The Eiffel Tower is in Paris and the Statue of Liberty is in New York."));
    }

    private static String validateString(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toLowerCase().toCharArray()){
            //ensures range is between [a-z]
            if(c >= 97 && c<=122){
                sb.append(c);
            }
        }
        //Make the first character uppercase again
        sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }
}
