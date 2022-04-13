package model.file;

import java.sql.Connection;
import model.db.userDBModel;

public class userModel implements fileModelInterface{
    private String uId;
    private String name;
    private int age;
    private String occupation;
    private int ucId;

    public void parseFromLine(String line){
        String[] seperated = line.split("\t");
        this.uId = seperated[0];
        this.name = seperated[1];
        this.age = Integer.parseInt(seperated[2]);
        this.occupation = seperated[3];
        this.ucId = Integer.parseInt(seperated[4]);

    }
    public void saveToDB(Connection connect){
        userDBModel userDBModel = new userDBModel(uId, name, age, occupation, ucId);
        userDBModel.insertToDB(connect);

    }
    
}
