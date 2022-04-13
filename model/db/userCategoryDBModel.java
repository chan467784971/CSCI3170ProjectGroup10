package model.db;

import java.sql.*;

public class userCategoryDBModel {
    private int ucId;
    private int maxNum;
    private int period;

    public userCategoryDBModel(int ucId, int maxNum, int period){
        this.ucId = ucId;
        this.maxNum = maxNum;
        this.period = period;

    }


    public void insertToDB(Connection connect){
        try {
            PreparedStatement statement = connect.prepareStatement("INSERT INTO user (ucId, maxNum, period) VALUE(?, ?, ?)");
            statement.setInt(1, ucId);
            statement.setInt(2, maxNum);
            statement.setInt(3, period);
            statement.execute();
            
        } catch (Exception e) {
            System.out.println("[Error] " + e);
        }

    }
}
