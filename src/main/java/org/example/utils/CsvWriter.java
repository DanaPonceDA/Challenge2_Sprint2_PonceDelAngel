package org.example.utils;

import com.opencsv.CSVWriter;//OpenCSV library for handling CSV files
import java.io.FileWriter;  // For writing files to disk
import java.io.IOException;// For handling input/output errors
import java.util.List;// For using Java lists

public class CsvWriter {

    public static void writeCsvFile(String filePath, List<String[]> data) throws IOException {
        //Open a CSV file and close it automatically when it finish
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath)    )) {
            //Write all rows of data in CSV file
            writer.writeAll(data);
            //Confirmation message in terminal
            System.out.println("Archivo CSV creado en: " + filePath);
        }
    }
}