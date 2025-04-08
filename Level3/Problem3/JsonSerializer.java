package week4_assignment6.Annotations.Level3.Problem3;

import java.lang.reflect.Field;
import java.util.*;

public class JsonSerializer {

    public static String convertToJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Map<String, String> jsonElements = new LinkedHashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name();
                Object value = field.get(obj);
                String jsonValue = value instanceof String ? "\"" + value + "\"" : String.valueOf(value);

                jsonElements.put(jsonKey, jsonValue);
            }
        }

        StringBuilder jsonBuilder = new StringBuilder("{\n");
        for (Map.Entry<String, String> entry : jsonElements.entrySet()) {
            jsonBuilder.append("  \"")
                    .append(entry.getKey())
                    .append("\": ")
                    .append(entry.getValue())
                    .append(",\n");
        }

        // Remove trailing comma
        if (!jsonElements.isEmpty()) {
            jsonBuilder.setLength(jsonBuilder.length() - 2);
            jsonBuilder.append("\n");
        }
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}
