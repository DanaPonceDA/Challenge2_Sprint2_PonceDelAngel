package org.example.models;


public class User {
//The fields in JSON file to convert into CSV
    private String name;
    private Integer age;
    private String gender;

    //A empty constructor to use  Jackson library
    public User() {}


    // This is the constructor to create a user directly in the code
    public User (String name, Integer age, String gender) {
        this.name =name;
        this.age= age;
        this.gender = gender;
    }

    /**
     * Gets the name of the user, gender and age
     * @return The user's name.
     */
    public String getName() { return name; } //Sets the name of the user.@param name The new name for the user.
    public String getGender() { return gender; }
    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }

    public Integer getAge() { return age; }
    public void setAge (Integer age ) { this.age = age; }
}