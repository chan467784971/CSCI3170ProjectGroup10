package model.db;

import java.sql.*;
import java.util.Calendar;

public class carDBModel {
    private String callNum;
    private int copyCount;
    private String carName;
    private String company;
    private Calendar manufacture;
    private int timeRent;
    private int ccId;

    public carDBModel(String callNum, int copyCount, String carName, String company, Calendar manufacture, int timeRent, int ccId){
        this.callNum = callNum;
        this.copyCount = copyCount;
        this.carName = carName;
        this.company = company;
        this.manufacture = manufacture;
        this.timeRent = timeRent;
        this.ccId = ccId;
    }

    public void insertToDB(Connection connect){
        try {
            PreparedStatement statement = connect.prepareStatement("INSERT INTO car (callNum, copyCount, carName, company, manufacture, timeRent, ccId) VALUES(?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, callNum);
            statement.setInt(2, copyCount);
            statement.setString(3, carName);
            statement.setString(4, company);
            statement.setDate(5, new Date(manufacture.getTimeInMillis()));
            statement.setInt(6, timeRent);
            statement.setInt(7, ccId);
            statement.execute();

        } catch (Exception e) {
            System.out.println("[Error] " + e);
        }

    }
    
}
