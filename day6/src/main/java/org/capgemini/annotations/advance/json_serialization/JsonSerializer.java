package org.capgemini.annotations.advance.json_serialization;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Serialization logic
public class JsonSerializer {
    public static String serialize(Object obj) throws IllegalAccessException {
        Map<String, String> jsonMap = new HashMap<>();
        Class<?> objClass = obj.getClass();

        for (Field field : objClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonMap.put(annotation.name(), field.get(obj).toString());
            }
        }

        return jsonMap.toString().replace("=", ":"); // Simple JSON conversion
    }
}