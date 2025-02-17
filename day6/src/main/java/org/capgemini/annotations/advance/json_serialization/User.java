package org.capgemini.annotations.advance.json_serialization;

// User class with annotated fields
public class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
