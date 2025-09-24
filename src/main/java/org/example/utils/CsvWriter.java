package org.example.utils;

import com.opencsv.CSVWriter;//OpenCSV library for handling CSV files
import java.io.FileWriter;  // For writing files to disk
import java.io.IOException;// For handling input/output errors
import java.util.List;// For using Java lists

/***@author: Dana Elizabeth Ponce Del Angel
 * Version: 1.0
 * Utility class for writing data to CSV files using the OpenCSV library.

 * This class provides a static method to create and write CSV files from
 * a list of String arrays, where each array represents a row in the CSV.

 * <b>Usage Example:</b>
 * {
     * @code
     *   List<String[]> data = new ArrayList<>();
     *   data.add(new String[]{"ID", "Name", "Age"});
     *   data.add(new String[]{"1", "Alice", "25"});
     *   data.add(new String[]{"2", "Bob", "30"});
     *
     *   try {
     *       CsvWriter.writeCsvFile("output.csv", data);
     *   } catch (IOException e) {
     *       e.printStackTrace();
     *   }
 * }
 */
public class CsvWriter {
    /**
     * Writes the given data into a CSV file at the specified path.
     *
     * Each element of the {@code data} list represents a row in the CSV file.
     * Each row is represented as a String array, where each String is a cell value.
     *
     * @param filePath The path where the CSV file will be created (e.g., "src/main/resources/Archivo.csv").
     * @param data     A list of String arrays representing rows of the CSV file.
     * @throws IOException If an error occurs while writing the file (e.g., invalid path or permissions).
     */

    public static void writeCsvFile(String filePath, List<String[]> data) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath)    )) {
            writer.writeAll(data);
            System.out.println("Archivo CSV creado en: " + filePath);
        }
    }
}
