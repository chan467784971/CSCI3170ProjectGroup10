package model.db;

import java.sql.*;

public class produceDBModel {
    private String cname;
    private String callnum;
  
    public produceDBModel(String company, String callnum) {
        this.cname = company;
        this.callnum = callnum;
    }
  
    public void insertToDatabase(Connection connect) {
        try {
            PreparedStatement statement = connect.prepareStatement("INSERT INTO produce (company, callNum) VALUES (?, ?)");
            statement.setString(1, cname);
            statement.setString(2, callnum);
            statement.execute();
        }catch (SQLException e) {
            System.out.println("[Error] " + e);
        }
    }
    
}
