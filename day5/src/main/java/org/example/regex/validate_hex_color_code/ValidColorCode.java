package org.example.validate_hex_color_code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidColorCode {
    public static void main(String[] args) {
        System.out.println(isValidColor("#244a2f"));
        System.out.println(isValidColor("#a222f6f"));
    }

    //returns true if a color has a valid hex code
    private static boolean isValidColor(String colorHex){
        String regex = "^#[0-9A-Fa-f]{6}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(colorHex);

        return matcher.matches();
    }
}
