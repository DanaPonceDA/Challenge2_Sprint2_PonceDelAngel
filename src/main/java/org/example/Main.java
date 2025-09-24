package org.example;

import org.example.models.User;
import org.example.utils.JsonReader;
import org.example.utils.CsvWriter;
import org.example.utils.UserTransformer;

import java.io.IOException;
import java.util.List;

/*
    *@author: Dana Elizabeth Ponce Del Angel
    * Version: 1.0
    * Main class of the application.
 *  <p>
 *  This program reads user data from a JSON file, validates the fields,
 *  prints the data to the console, and exports it to a CSV file.
 *
 *  Usage Example:
 *  {
 *      @code
 *      java -cp target/myapp.jar org.example.Main
 *  }
 *
 *  The application expects the following files:
 *  - Archivo.json (input, JSON format)
 *  - Archivo.csv (output, CSV format)
 */
public class Main {
    /**
     * Main entry point of the application.
     *
     * @param args Command-line arguments (not used in this implementation).
     */

    public static void main(String[] args) {
        String jsonPath = "src/main/resources/Archivo.json";
        String csvPath = "src/main/resources/Archivo.csv";

        try {
            List<User> users = JsonReader.readJsonFile(jsonPath, User.class);
            validateUsers(users);
            System.out.println("Users from JSON:");
            users.forEach(u -> System.out.println(u.getId() + " - " +  u.getName() + " - " +  u.getGender() + " - " + u.getAge()  + " - " + u.getPrincipalNumber()  + " - " + u.getAdress()));

            List<String[]> csvData = UserTransformer.transformUsersToCsvData(users);
            CsvWriter.writeCsvFile(csvPath, csvData);

        } catch (IOException e) {
            System.err.println("En algo te estas equivocando: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }
    /**
     * Validates a list of users, ensuring all required fields are present and valid
     * The following validations are performed:
     * <ul>
     *     <li>Name cannot be null or empty.</li>
     *     <li>Gender cannot be null or empty.</li>
     *     <li>Principal number cannot be null or empty.</li>
     *     <li>Address cannot be null or empty.</li>
     *     <li>Age must not be null and must be greater than or equal to 0.</li>
     * </ul>
     *
     * @param users List of {@link User} objects to validate.
     * @throws IllegalArgumentException if any validation fails.
     */
    private static void validateUsers(List<User> users) {
        for (User user : users) {
            if (user.getName() == null || user.getName().trim().isEmpty()) {
                throw new IllegalArgumentException("Falta el campo 'name' para el usuario con ID: " + user.getId());
            }

            if (user.getGender() == null || user.getGender().trim().isEmpty()) {
                throw new IllegalArgumentException("Falta el campo 'Genero' para el usuario: con ID: " + user.getId());
            }
            if (user.getPrincipalNumber() == null || user.getPrincipalNumber().trim().isEmpty()) {
                throw new IllegalArgumentException("Falta el campo 'Principal Number' para el usuario: con ID: " + user.getId());
            }
            if (user.getAdress() == null || user.getAdress().trim().isEmpty()) {
                throw new IllegalArgumentException("Falta el campo 'Adress' para el usuario: con ID: " + user.getId());
            }
            if (user.getAge() == null || user.getAge()<0 ) {
                if(user.getAge() == null){
                    throw new IllegalArgumentException("Falta el campo 'Edad' para el usuario: con ID: " + user.getId());
                } else {
                    throw new IllegalArgumentException("Edad no valida en uno de los usuarios");
                }
            }
        }
    }
}
