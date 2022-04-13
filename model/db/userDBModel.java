package model.db;

import java.sql.*;

public class userDBModel {
    private String uId;
    private String name;
    private int age;
    private String occupation;
    private int ucId;


    public userDBModel(String uId, String name, int age, String occupation, int ucId){
        this.uId = uId;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.ucId = ucId;

    }

    public void insertToDB(Connection connect){
        try{
            PreparedStatement statement = connect.prepareStatement("INSERT INTO user (uId, name, age, occupation, ucId) VALUE(?, ?, ?, ?, ?)");
            statement.setString(1, uId);
            statement.setString(2, name);
            statement.setInt(3, age);
            statement.setString(4, occupation);
            statement.setInt(5, ucId);
            statement.execute();
            
        } catch (Exception e) {
            System.out.println("[Error] " + e);
        }

    }
    
}
