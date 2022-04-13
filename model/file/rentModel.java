package model.file;

import java.sql.Connection;

import model.DataConvert;
import model.db.rentDBModel;
import java.util.Calendar;

public class rentModel implements fileModelInterface{
    private String callNum;
    private int copyNum;
    private String uId;
    private Calendar checkout;
    private Calendar return_date;

    public void parseFromLine(String line){
        String[] seperated = line.split("\t");
        this.callNum = seperated[0];
        this.copyNum = Integer.parseInt(seperated[1]);
        this.uId = seperated[2];
        this.checkout = DataConvert.toCalendar(seperated[3]);
        this.return_date = DataConvert.toCalendar(seperated[4]);

    }
    public void saveToDB(Connection connect){
        rentDBModel rentDBModel = new rentDBModel(callNum, copyNum, uId, checkout, return_date);
        rentDBModel.insertToDB(connect);

    }
    
}
