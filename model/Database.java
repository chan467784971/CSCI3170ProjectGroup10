package model;

import java.sql.*;
import java.util.*;
import java.io.*;
import model.file.*;

public class Database {
    private String dbAddress = "jdbc:mysql://projgw.cse.cuhk.edu.hk:2633/db10";
    private String dbUsername = "Group10";
    private String dbPassword = "CSCI3170";
    private Connection connect = null;

    final String[] tables = {"car", "carCategory", "user", "userCategory", "rent"};

    // Operation
    public boolean Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connect = DriverManager.getConnection(dbAddress, dbUsername, dbPassword);
        } catch(ClassNotFoundException e) {
            System.out.println("[Error]: Java MySQL DB Driver not found!!!");
            return false;
        } catch(SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    //Admin operation
    public void creatAllTable() throws SQLException {
        // preparedstatement ???????
        PreparedStatement[] statements = {
            //SQL create table statement
            connect.prepareStatement("CREATE TABLE car (callNum CHAR(8) NOT NULL, copyNum INTEGER(1) NOT NULL, carName CHAR(10) NOT NULL, companyName CHAR(25) NOT NULL, manufacture DATE NOT NULL, timeRent INTEGER(2) NOT NULL, ccId INTEGER(1) NOT NULL, PRIMARY KEY (callNum))"),
            connect.prepareStatement("CREATE TABLE carCategory (ccId INTEGER(1) NOT NULL, ccName CHAR(20) NOT NULL, PRIMARY KEY (ccId))"),
            connect.prepareStatement("CREATE TABLE user (uId CHAR(12) NOT NULL, name CHAR(25) NOT NULL, age INTEGER(2) NOT NULL, occupation CHAR(20) NOT NULL, userCate INTEGER(1) NOT NULL, PRIMARY KEY (uId))"),
            connect.prepareStatement("CREATE TABLE userCategory (ucId INTEGER(1) NOT NULL, max INTEGER(1) NOT NULL, period INTEGER(2) NOT NULL, PRIMARY KEY(ucId))"),
            connect.prepareStatement("CREATE TABLE rent (callNum CHAR(8) NOT NULL, copyNum INTEGER(1) NOT NULL, uId CHAR(12) NOT NULL, checkout DATE NOT NULL, return_date DATE, PRIMARY KEY(checkout))")
        };

        for (int i = 0; i < statements.length; i++){
            statements[i].execute();
        }
    }

    public void deleteAllTable() throws SQLException {
        for(int i = 0; i < tables.length; i++){
            PreparedStatement statement = connect.prepareStatement("DROP TABLE " + tables[i]);
            statement.execute();
        }

    }

    public void loadFromDataFile(String folderPath){
        readFiletoDB(folderPath + "car_category.txt", carCategoryModel.class);
        // readFiletoDB(folderPath + "car.txt", type);
        // readFiletoDB(folderPath + "rent.txt", type);
        // readFiletoDB(folderPath + "user_category.txt", type);
        // readFiletoDB(folderPath + "user.txt", type);

    }

    private void readFiletoDB(String folderPath, Class<?> type){
        
    }

    //Admin operation end

    public void showSchema(String[] argument) {

    }
    

    public void insertRecord(String[] argument) {

    }

    public void updateRecord(String[] argument) {

    }

    public void deleteRecord(String[] argument) {

    }

    





}