package org.capgemini.annotations.intermediate_level.field_validation;

import java.lang.reflect.Field;

// User class with field validation
public class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        validate(username);
        this.username = username;
    }

    private void validate(String username) {
        try {
            Field field = User.class.getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength);
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}