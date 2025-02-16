package org.example.validate_credit_card;

import java.util.regex.Pattern;

public class ValidateCreditCard {
    public static void main(String[] args) {
        String card1 = "4111111111111111"; // Visa - Valid
        String card2 = "5111111111111111"; // MasterCard - Valid
        String card3 = "6111111111111111"; // Invalid
        String card4 = "4222222222222";    // Invalid (Visa, but only 13 digits)
        String card5 = "5200000000000000"; // MasterCard - Valid

        System.out.println(card1 + " -> " + isValidCreditCard(card1));
        System.out.println(card2 + " -> " + isValidCreditCard(card2));
        System.out.println(card3 + " -> " + isValidCreditCard(card3));
        System.out.println(card4 + " -> " + isValidCreditCard(card4));
        System.out.println(card5 + " -> " + isValidCreditCard(card5));
    }

    public static boolean isValidCreditCard(String cardNumber) {
        String regex = "^(4\\d{15}|5\\d{15})$";
        return Pattern.matches(regex, cardNumber);
    }
}
