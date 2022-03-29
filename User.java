import java.sql.*;

public class User {
    private String id;
    private String name;
    private int age;
    private String occupation;
    private int categoryId;

    // Initialization
    public User(String id, String name, int age, String occupation, int categoryId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.categoryId = categoryId;
    }

    // Property
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getOccupation() {
        return this.occupation;
    }
    
    public String getCategoryId() {
        return this.categoryId;
    }

    // Operation
    public void searchCar() {
        
    }

    public void searchByCallNumber() {

    }

    public void searchByCarName() {

    }

    public void searchByCompany() {

    }

    public void showRecord() {

    }





}