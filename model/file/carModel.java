package model.file;

import java.sql.Connection;
import model.db.carDBModel;
import model.db.copyDBModel;
import model.db.produceDBModel;

import java.util.Calendar;

import model.*;

public class carModel implements fileModelInterface {
    private String callNum;
    private int copyCount;
    private String carName;
    private String company;
    private Calendar manufacture;
    private int timeRent;
    private int ccId;

    public void parseFromLine(String line){
        String[] seperated = line.split("\t");
        this.callNum = seperated[0];
        this.copyCount = Integer.parseInt(seperated[1]);
        this.carName = seperated[2];
        this.company = seperated[3];
        this.manufacture = DataConvert.toCalendar(seperated[4]);
        this.timeRent = Integer.parseInt(seperated[5]);
        this.ccId = Integer.parseInt(seperated[6]);
    }
    public void saveToDB(Connection connect){
        carDBModel car = new carDBModel(callNum, copyCount, carName, company, manufacture, timeRent, ccId);
        car.insertToDB(connect);
        for (int copynum = 1; copynum <= copyCount; copynum++) {
            copyDBModel copy = new copyDBModel(callNum, copynum);
            copy.insertToDatabase(connect);
        }
        produceDBModel produce  = new produceDBModel(company, callNum);
        produce.insertToDatabase(connect);
      

    }
    
}
