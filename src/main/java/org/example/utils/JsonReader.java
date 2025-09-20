package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper; //Jackson library to use JSON files.
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * A utility class for reading and deserializing JSON files using the Jackson library.
 */
public class JsonReader {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Reads and deserializes a JSON file into a list of objects of a specified type.
     * The file is expected to contain a JSON array.
     *
     * @param <T> The class type of the objects in the JSON array.
     * @param filePath The path to the JSON file.
     * @param clazz The Class object representing the type of the elements in the list.
     * @return A list of objects deserialized from the JSON file.
     * @throws IOException if the file does not exist, or if there is an error during
     * reading or JSON parsing.
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