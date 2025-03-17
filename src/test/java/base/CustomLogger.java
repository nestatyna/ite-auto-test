package base;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CustomLogger {

    public static void log(String message) {
        System.out.println(message);
    }

    public static void step(String message) {
        log(message);
    }

    public static void error(String message) {
        System.err.println(message);
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String prettyJson(String jsonString) {
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (IOException e) {
            return "Ошибка при форматировании JSON: " + e.getMessage();
        }
    }
}
