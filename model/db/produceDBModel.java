package model.db;

import java.sql.*;

public class produceDBModel {
    private String cname;
    private String callnum;
  
    public ProduceDBModel(String carname, String callnum) {
        this.cname = cname;
        this.callnum = callnum;
    }
  
    public void insertToDatabase(Connection connect) {
        try {
            PreparedStatement statement = connect.prepareStatement("INSERT INTO produce (cname, callnum) VALUES (?, ?)");
            statement.setString(1, cname);
            statement.setString(2, callnum);
            statement.execute();
        }catch (SQLException e) {
            System.out.println("[Error] " + e);
        }
    }
    
}
