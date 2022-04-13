package model.db;

import java.sql.*;

public class carCategoryDBModel {
    private int ccId;
    private String ccName; 

    public carCategoryDBModel(int ccId, String ccName){
        this.ccId = ccId;
        this.ccName = ccName;
    }
    
    public void insertToDB(Connection connect){
        try{
            PreparedStatement statement = connect.prepareStatement("INSERT INTO carCategory (ccId, ccName) VALUES(?, ?)");
            statement.setInt(1, ccId);
            statement.setString(2, ccName);
            statement.execute();

        }catch(SQLException e){
            System.out.println("[Error] " + e);
        }
    }
}
