package org.example;

import org.example.models.User;
import org.example.utils.JsonReader;
import org.example.utils.CsvWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String jsonPath = "src/main/resources/Archivo.json"; //The JSON file to be read
        String csvPath = "src/main/resources/Archivo.csv"; //The CSV file to be writte

        try {
            //Read users in Json file and convert it in User type.
            List<User> users = JsonReader.readJsonFile(jsonPath, User.class);

            // Validate all users have complete data
            validateUsers(users);

            //If there no errors, then this will print the list from Json file
            System.out.println("Users from JSON:");
            users.forEach(u -> System.out.println(u.getName() + " - " +  u.getGender() + " - " + u.getAge()));


            List<String[]> csvData = new ArrayList<>();//Prepare the data to export
            csvData.add(new String[]{"Name", "Gender", "Age"}); //The first row to the columns
            for (User user : users) { //Loop through the list of users and add each one as CSV file
                csvData.add(new String[]{user.getName(),
                        user.getGender(),
                        String.valueOf(user.getAge())});
            }

            //Call the class CsvWriter to save the data in the file.
            CsvWriter.writeCsvFile(csvPath, csvData);

            //If an error happenwhen it read or write or in the validation, the screen will print a message
        } catch (IOException e) {
            System.err.println("En algo te estas equivocando: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }
    // Method that validates that all users have their fields correct
    private static void validateUsers(List<User> users) {
        for (User user : users) {
            //If there's a user without field "name"
            if (user.getName() == null || user.getName().trim().isEmpty()) {
                throw new IllegalArgumentException("Falta el campo 'name' para el usuario de edad: " + user.getAge());
            }
            //If there's a user without field "gender"
            if (user.getGender() == null || user.getGender().trim().isEmpty()) {
                throw new IllegalArgumentException("Falta el campo 'Genero' para el usuario: " + user.getName());
            }
            //If there's a user without field "age"
            if (user.getAge() == null || user.getAge()<0 ) {
                if(user.getAge() == null){ //If "age" is null or empity
                    throw new IllegalArgumentException("Falta el campo 'age' para la edad: " + user.getName());
                } else { //If the Age is minor than 0
                    throw new IllegalArgumentException("Edad no valida en uno de los usuarios");
                }
            }
        }
    }
}