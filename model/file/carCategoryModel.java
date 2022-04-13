package model.file;

import java.sql.Connection;
import model.db.carCategoryDBModel;


public class carCategoryModel {
    private int ccId;
    private String ccName; 

    public void parseFromLine(String line){
        String[] seperated = line.split("\t");
        this.ccId = Integer.parseInt(seperated[0]);
        this.ccName = seperated[1];
    }


    public void saveToDB(Connection connect){
        carCategoryDBModel carCategory = new carCategoryDBModel(ccId, ccName);
        carCategory.insertToDB(connect);
    }
    
}
