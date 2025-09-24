package org.example.utils;

import org.example.models.User;
import java.util.ArrayList;
import java.util.List;

/**
 * *@author: Dana Elizabeth Ponce Del Angel
 *     * Version: 1.0
 * Utility class for transforming User objects into a format suitable for CSV export.
 *
 * This class provides a method to convert a list of {@link User} objects into
 * a list of String arrays, where each array represents a row in a CSV file.
 *
 * <b>Usage Example:</b>
 * {
     * @code
     *   List<User> users = new ArrayList<>();
     *   users.add(new User(1, "Alice", 25, "Female", "555-1234", "123 Main St"));
     *   users.add(new User(2, "Bob", 30, "Male", "555-5678", "456 Elm St"));
     *
     *   List<String[]> csvData = UserTransformer.transformUsersToCsvData(users);
     *
     *   for (String[] row : csvData) {
     *       System.out.println(Arrays.toString(row));
     *   }
 * }
 */

public class UserTransformer {
    /**
     * Transforms a list of {@link User} objects into a list of String arrays
     * suitable for writing to a CSV file.
     *
     * <p>The first row of the resulting list contains the CSV headers:
     * "Id", "Name", "Gender", "Age", "Principal Number", "Adress".</p>
     *
     * @param users List of {@link User} objects to transform.
     * @return A list of String arrays representing CSV rows.
     */
    public static List<String[]> transformUsersToCsvData(List<User> users) {
        List<String[]> csvData = new ArrayList<>();
        csvData.add(new String[]{"Id", "Name", "Gender", "Age", "Principal Number", "Adress"});

        for (User user : users) {
            csvData.add(new String[]{
                    String.valueOf(user.getId()),
                    user.getName(),
                    user.getGender(),
                    String.valueOf(user.getAge()),
                    user.getPrincipalNumber(),
                    user.getAdress()
            });
        }
        return csvData;
    }
}
