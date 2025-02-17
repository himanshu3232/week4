package org.capgemini.annotations.advance.json_serialization;

// Test the annotation
public class JsonSerializationTest {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Alice", 25);
        String json = JsonSerializer.serialize(user);
        System.out.println(json);
    }
}
