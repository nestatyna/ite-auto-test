package helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import data.FilePath;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static base.CustomLogger.error;
import static base.TestBase.softAssert;
import static java.lang.String.format;
import static java.nio.file.Paths.get;

public class JsonHelper {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

    public static <T> Map<String, T> parseJsonInToMap(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory()
                    .constructMapType(Map.class, String.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка десериализации JSON", e);
        }
    }

    public static <T> List<T> parseJsonToList(String jsonString, Class<T> clazz) {
        try {
            if (!isValidArrayJson(jsonString)) {
                throw new RuntimeException("Некорректный JSON: " + jsonString);
            }

            return objectMapper.readValue(jsonString,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (UnrecognizedPropertyException e) {
            softAssert.fail("Ошибка: " + e.getOriginalMessage());

            try {
                ObjectMapper relaxedMapper = new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return relaxedMapper.readValue(jsonString,
                        relaxedMapper.getTypeFactory().constructCollectionType(List.class, clazz));
            } catch (IOException ex) {
                throw new RuntimeException("Ошибка десериализации JSON после игнорирования неизвестных полей", ex);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка десериализации JSON в List<" + clazz.getSimpleName() + ">", e);
        }
    }

    public static boolean isValidJson(String json) {
        try {
            objectMapper.readTree(json);
            return true;
        } catch (JsonProcessingException e) {
            error("Ошибка в JSON: " + e.getOriginalMessage());
            error(format("Ошибка на строке: %s, колонке: %s", e.getLocation().getLineNr(), e.getLocation().getColumnNr()));
            return false;
        }
    }

    public static boolean isValidArrayJson(String json) {
        try {
            JsonNode rootNode = objectMapper.readTree(json);
            if (!rootNode.isArray()) {
                error("Ошибка: JSON должен быть массивом (начинаться с [ и заканчиваться на ])");
                return false;
            }
            return true;
        } catch (JsonProcessingException e) {
            error("Ошибка в JSON: " + e.getOriginalMessage());
            error(format("Ошибка на строке: %s, колонке: %s", e.getLocation().getLineNr(), e.getLocation().getColumnNr()));
            return false;
        }
    }

    public static <T> T readJsonObject(FilePath filePath, Class<T> clazz) {
        Path path = Paths.get(filePath.getPath());
        try {
            return objectMapper.readValue(path.toFile(), clazz);

        } catch (UnrecognizedPropertyException e) {
            error("Ошибка: " + e.getOriginalMessage());

            try {
                ObjectMapper relaxedMapper = new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return relaxedMapper.readValue(path.toFile(), clazz);
            } catch (IOException ex) {
                throw new RuntimeException("Ошибка десериализации JSON после игнорирования неизвестных полей", ex);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения JSON-файла: " + filePath, e);
        }
    }

    public static <T> List<T> readJsonArray(FilePath filePath, Class<T> clazz) {
        Path path = get(filePath.getPath());
        try {
            return objectMapper.readValue(
                    path.toFile(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, clazz)
            );
        } catch (UnrecognizedPropertyException e) {
            error("Ошибка: " + e.getOriginalMessage());

            try {
                ObjectMapper relaxedMapper = new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return relaxedMapper.readValue(
                        path.toFile(),
                        relaxedMapper.getTypeFactory().constructCollectionType(List.class, clazz));
            } catch (IOException ex) {
                throw new RuntimeException("Ошибка десериализации JSON после игнорирования неизвестных полей", ex);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения JSON-файла: " + filePath, e);
        }
    }

    public static String toJsonStringInLine(Object object) {
        try {
            return objectMapper.writer().without(SerializationFeature.INDENT_OUTPUT).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
