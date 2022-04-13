package model.db;

import java.sql.*;

public class userCategoryDBModel {
    private int ucId;
    private int max;
    private int period;

    public userCategoryDBModel(int ucId, int max, int period){
        this.ucId = ucId;
        this.max = max;
        this.period = period;

    }


    public void insertToDB(Connection connect){
        try {
            PreparedStatement statement = connect.prepareStatement("INSERT INTO user (ucId, max, period) VALUE(?, ?, ?)");
            statement.setInt(1, ucId);
            statement.setInt(2, max);
            statement.setInt(3, period);
            statement.execute();
            
        } catch (Exception e) {
            System.out.println("[Error] " + e);
        }

    }
}
