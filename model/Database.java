package model;

import java.sql.*;

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

    public void creatAllTable() throws SQLException {
        // preparedstatement ???????
        PreparedStatement[] statements = {
            //SQL create table statement
            connect.prepareStatement("CREATE TABLE car (callNumber CHAR(8) NOT NULL, numOfCopies INTEGER(1) NOT NULL, carName CHAR(10) NOT NULL, company CHAR(25) NOT NULL, manuDate DATE NOT NULL, numOfRent INTEGER(2) NOT NULL, carCate INTEGER(1) NOT NULL, PRIMARY KEY (callNumber))"),
            connect.prepareStatement("CREATE TABLE carCategory (carCate INTEGER(1) NOT NULL, carCateName CHAR(20) NOT NULL, PRIMARY KEY (carCate))"),
            connect.prepareStatement("CREATE TABLE user (userID CHAR(12) NOT NULL, name CHAR(25) NOT NULL, age INTEGER(2) NOT NULL, occupa CHAR(20) NOT NULL, userCate INTEGER(1) NOT NULL, PRIMARY KEY (userCate))"),
            connect.prepareStatement("CREATE TABLE userCategory (userCate INTEGER(1) NOT NULL, maxCar INTEGER(1) NOT NULL, loanP INTEGER(2) NOT NULL, PRIMARY KEY(userCate))"),
            connect.prepareStatement("CREATE TABLE rent (callNumber CHAR(8) NOT NULL, numOfCopies INTEGER(1) NOT NULL, userID CHAR(12) NOT NULL, checkout DATE NOT NULL, return_date DATE, PRIMARY KEY(checkout))")
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
        // readFiletoDB(folderPath + "car_category.txt", type);
        // readFiletoDB(folderPath + "car.txt", type);
        // readFiletoDB(folderPath + "rent.txt", type);
        // readFiletoDB(folderPath + "user_category.txt", type);
        // readFiletoDB(folderPath + "user.txt", type);

    }

    private void readFiletoDB(String folderPath, Class<?> type){
        
    }

    public void showSchema(String[] argument) {

    }

    public void insertRecord(String[] argument) {

    }

    public void updateRecord(String[] argument) {

    }

    public void deleteRecord(String[] argument) {

    }

    





}