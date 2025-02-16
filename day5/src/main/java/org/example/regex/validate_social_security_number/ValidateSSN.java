package org.example.validate_social_security_number;

import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String ssn1 = "123-45-6789";  // Valid
        String ssn2 = "123456789";    // Invalid
        String ssn3 = "987-65-4321";  // Valid
        String ssn4 = "12-345-6789";  // Invalid

        System.out.println(ssn1 + " -> " + isValidSSN(ssn1));
        System.out.println(ssn2 + " -> " + isValidSSN(ssn2));
        System.out.println(ssn3 + " -> " + isValidSSN(ssn3));
        System.out.println(ssn4 + " -> " + isValidSSN(ssn4));
    }

    public static boolean isValidSSN(String ssn) {
        String regex = "^(\\d{3}-\\d{2}-\\d{4})$"; // Matches SSN in the format XXX-XX-XXXX
        return Pattern.matches(regex, ssn);
    }
}

