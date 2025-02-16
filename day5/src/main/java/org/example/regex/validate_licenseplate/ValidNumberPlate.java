package org.example.validate_licenseplate;

import java.util.regex.Pattern;

public class ValidNumberPlate {
    public static void main(String[] args) {
        //prints true if number plate is valid
        System.out.println(isValid("BR1987"));
        System.out.println(isValid("MPa1000"));
    }

    private static boolean isValid(String numberPlate){
        //License plate format: Starts with two uppercase letters, followed by four digits.
        //Example: "AB1234" is valid, but "A12345" is invalid.
        String regex = "^[A-Z]{2}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(numberPlate).matches();
    }
}
