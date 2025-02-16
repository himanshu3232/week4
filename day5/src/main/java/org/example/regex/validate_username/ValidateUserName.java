package org.example.validate_username;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUserName {
    public static void main(String[] args) {

        //prints true if username is valid
        System.out.println(isValid("hello1"));
        System.out.println(isValid("12valid"));
    }

    //checks if the username is valid
    private static boolean isValid(String username){
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{5,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
