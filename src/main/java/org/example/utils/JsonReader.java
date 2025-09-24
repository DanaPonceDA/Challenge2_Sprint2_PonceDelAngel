package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper; //Jackson library to use JSON files.
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * *@author: Dana Elizabeth Ponce Del Angel
 *     * Version: 1.0
 * Utility class for reading JSON files and converting them into Java objects using Jackson.
 *
 * <p>This class provides a static method that reads a JSON file and deserializes
 * it into a list of objects of a specified type.</p>
 *
 * <b>Usage Example:</b>
 * {
     * @code
     *   try {
     *       List<User> users = JsonReader.readJsonFile("src/main/resources/users.json", User.class);
     *       for (User user : users) {
     *           System.out.println(user.getName());
     *       }
     *   } catch (IOException e) {
     *       e.printStackTrace();
     *   }
 * }
 */

public class JsonReader {

    /** Shared ObjectMapper instance for JSON parsing. */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Reads a JSON file and deserializes it into a list of objects of the specified type.
     *
     * @param filePath The path to the JSON file (e.g., "src/main/resources/Archivo.json").
     * @param clazz    The class type of the objects to be deserialized (e.g., {@code User.class}).
     * @param <T>      The type parameter representing the object type.
     * @return A list of objects of type {@code T} read from the JSON file.
     * @throws IOException If the file cannot be read or parsed (e.g., invalid JSON format or missing file).
     */

    public static <T> List<T> readJsonFile(String filePath, Class<T> clazz) throws IOException {
        //Create a file pointing the route to file JSON
        File file = new File(filePath);
        //Deserializes the JSON file to a list of objects of the specified type
        return objectMapper.readValue(
                file,
                objectMapper.getTypeFactory().constructCollectionType(List.class, clazz)
        );
    }
}
