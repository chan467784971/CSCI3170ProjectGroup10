package model.file;

import java.sql.Connection;
import model.db.carDBModel;
import java.util.Calendar;

import model.*;

public class carModel implements fileModelInterface {
    private String callNum;
    private int copyNum;
    private String carName;
    private String company;
    private Calendar manufacture;
    private int timeRent;
    private int ccId;

    public void parseFromLine(String line){
        String[] seperated = line.split("\t");
        this.callNum = seperated[0];
        this.copyNum = Integer.parseInt(seperated[1]);
        this.carName = seperated[2];
        this.company = seperated[3];
        this.manufacture = DataConvert.toCalendar(seperated[4]);
        this.timeRent = Integer.parseInt(seperated[5]);
        this.ccId = Integer.parseInt(seperated[6]);
    }
    public void saveToDB(Connection connect){
        carDBModel car = new carDBModel(callNum, copyNum, carName, company, manufacture, timeRent, ccId);
        car.insertToDB(connect);

    }
    
}
