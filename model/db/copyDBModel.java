package model.db;

import java.sql.*;

public class copyDBModel {
    private String callnum;
    private int copynum;

    public CopyDBModel(String callnum, int copynum) {
        this.callnum = callnum;
        this.copynum = copynum;
    }

    public void insertToDatabase(Connection connect) {
        try {
            PreparedStatement statement = connect.prepareStatement("INSERT INTO copy (callnum, copynum) VALUES (?, ?)");
            statement.setString(1, callnum);
            statement.setInt(2, copynum);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("[Error] " + e);
        }
    }

    
}
