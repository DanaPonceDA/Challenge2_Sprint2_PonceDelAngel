package org.example.models;

/**
 *@author: Dana Elizabeth Ponce Del Angel
 * Version: 1.0
     * Represents a User entity with personal information such as
     * ID, name, age, gender, principal phone number, and address.
     * This class is commonly used to map data read from JSON files
     * and to export the data into CSV format.
     * <b>Usage Example:</b>
     * {
    *    @code
     *   User user = new User(1, "Cristobal", 33, "Male", "8485869322", "Calle Aguaviva #89");
     *   System.out.println(user.getName()); // Output: Cristobal
     * }
 */

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String principalNumber;
    private String adress;

    /**
         * Default constructor.
         * Creates an empty User object with no initialized fields.
     */
    public User()

    /**
         * Parameterized constructor to initialize a User with all fields.
         *
         * @param id              Unique identifier of the user.
         * @param name            Full name of the user.
         * @param age             Age of the user.
         * @param gender          Gender of the user.
         * @param principalNumber Principal phone number of the user.
         * @param adress          Address of the user.
     */

    public User (int id, String name, Integer age, String gender, String principalNumber, String adress) {
        this.id = id;
        this.name =name;
        this.age= age;
        this.gender = gender;
        this.adress = adress;
        this.principalNumber = principalNumber;
    }

    /**
     * Gets the user's name, gender, principalNumber, adress.
     *
     * @return the user's name, gender, principalNumber, adress.
     */
    public String getName() { return name; } //Sets the name of the user.@param name The new name for the user.
    public String getGender() { return gender; }
    public String getPrincipalNumber() { return principalNumber; }
    public String getAdress() { return adress; }

    /**
     * Sets the user's name, gender, principalNumber, adress.
     *
     * @param name, gender, principalNumber, adress for the user.
     */

    public void setName(String name) {
        this.name = name; }
    public void setGender(String gender) {
        this.gender = gender; }
    public void setPrincipalNumber(String principalNumber) {
        this.principalNumber = principalNumber; }
    public void setAdress( String adress) {
        this.adress = adress; }

    public Integer getId() { return id; }
    public void setId ( Integer id ) { this.id = id; }
    public Integer getAge() { return age; }
    public void setAge (Integer age ) { this.age = age; }
}
