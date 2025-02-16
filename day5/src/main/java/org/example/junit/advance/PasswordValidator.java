package org.example.junit.advance;

public class PasswordValidator {
    public static boolean isValid(String password) {
        return password.length() >= 8 &&
                password.chars().anyMatch(Character::isUpperCase) &&
                password.chars().anyMatch(Character::isDigit);
    }
}