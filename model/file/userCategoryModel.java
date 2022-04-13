package model.file;

import java.sql.Connection;
import model.db.userCategoryDBModel;

public class userCategoryModel implements fileModelInterface{
    private int ucId;
    private int maxNum;
    private int period;

    public void parseFromLine(String line){
        String[] seperated = line.split("\t");
        this.ucId = Integer.parseInt(seperated[0]);
        this.maxNum = Integer.parseInt(seperated[1]);
        this.period = Integer.parseInt(seperated[2]);

    }
    public void saveToDB(Connection connect){
        userCategoryDBModel userCategoryDBModel = new userCategoryDBModel(ucId, maxNum, period);
        userCategoryDBModel.insertToDB(connect);

    }
    
}
