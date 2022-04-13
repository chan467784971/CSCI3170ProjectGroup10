package model.db;

import java.sql.*;
import java.util.Calendar;

public class rentDBModel {
    private String callNum;
    private int copyNum;
    private String uId;
    private Calendar checkout;
    private Calendar return_date;

    public rentDBModel(String callNum, int copyNum, String uId, Calendar checkout, Calendar return_date){
        this.callNum = callNum;
        this.copyNum = copyNum;
        this.uId = uId;
        this.checkout = checkout;
        this.return_date = return_date;

    }

    public void insertToDB(Connection connect){
        try {
            PreparedStatement statement = connect.prepareStatement("INSERT INTO rent (callNum, copyNum, uId, checkout, return_date) VALUE(?, ?, ?, ?, ?)");
            statement.setString(1, callNum);
            statement.setInt(2, copyNum);
            statement.setString(3, uId);
            statement.setDate(4, new Date(checkout.getTimeInMillis()));
            if (return_date == null){
                statement.setNull(5, Types.DATE);
            }else{
                statement.setDate(5, new Date(return_date.getTimeInMillis()));
            }
            statement.execute();


        } catch (Exception e) {
            System.out.println("[Error] " + e);
        }

    }
    
}
