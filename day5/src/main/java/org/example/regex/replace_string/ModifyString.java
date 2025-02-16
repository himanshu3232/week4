package org.example.replace_string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModifyString {
    public static void main(String[] args) {
        //removes multiple spaces and prints single space text
        System.out.println(modifyString("This   is an   example with multiple  spaces."));
    }

    //
    private static String modifyString(String text) {
        //looks for one or more spaces
        Matcher matcher = Pattern.compile("\\s+").matcher(text);
        //replaces all patterns with single space
        return matcher.replaceAll(" ");
    }
}
