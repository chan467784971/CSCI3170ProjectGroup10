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

    final String[] tables = {"car", "carCategory", "user", "userCategory", "rent", "copy", "produce"};

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
            connect.prepareStatement("CREATE TABLE car (callNum CHAR(8) NOT NULL, copyCount INTEGER(1) NOT NULL, carName CHAR(10) NOT NULL, company CHAR(25) NOT NULL, manufacture DATE NOT NULL, timeRent INTEGER(2) NOT NULL, ccId INTEGER(1) NOT NULL, PRIMARY KEY (callNum))"),
            connect.prepareStatement("CREATE TABLE carCategory (ccId INTEGER(1) NOT NULL, ccName CHAR(20) NOT NULL, PRIMARY KEY (ccId))"),
            connect.prepareStatement("CREATE TABLE user (uId CHAR(12) NOT NULL, name CHAR(25) NOT NULL, age INTEGER(2) NOT NULL, occupation CHAR(20) NOT NULL, ucId INTEGER(1) NOT NULL, PRIMARY KEY (uId))"),
            connect.prepareStatement("CREATE TABLE userCategory (ucId INTEGER(1) NOT NULL, maxNum INTEGER(1) NOT NULL, period INTEGER(2) NOT NULL, PRIMARY KEY(ucId))"),
            connect.prepareStatement("CREATE TABLE rent (callNum CHAR(8) NOT NULL, copyNum INTEGER(1) NOT NULL, uId CHAR(12) NOT NULL, checkout DATE NOT NULL, return_date DATE, PRIMARY KEY(callNum, copyNum, uId, checkout))"),
            connect.prepareStatement("CREATE TABLE copy (callNum CHAR(8) NOT NULL, copyNum INTEGER(1) NOT NULL, PRIMARY KEY (callNum, copyNum))"),
            connect.prepareStatement("CREATE TABLE produce (company CHAR(25) NOT NULL, callNum CHAR(8) NOT NULL, PRIMARY KEY (company, callNum))")
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
        readFiletoDB(folderPath + "car.txt", carModel.class);
        readFiletoDB(folderPath + "rent.txt", rentModel.class);
        readFiletoDB(folderPath + "user_category.txt", userCategoryModel.class);
        readFiletoDB(folderPath + "user.txt", userModel.class);

    }

    private void readFiletoDB(String folderPath, Class<?> type){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(folderPath));
            String line = reader.readLine();
            while (line != null){
                fileModelInterface model = (fileModelInterface) type.newInstance();
                model.parseFromLine(line);
                model.saveToDB(connect);
                line = reader.readLine();
            }
        }catch(Exception e){
            System.out.println("[Error] " + e);
        }
        
    }

    public void showNumOfRecords(){
        for (int i = 0; i < tables.length; i++) {
            try {
                PreparedStatement statement = connect.prepareStatement("SELECT COUNT(*) FROM " + tables[i]);
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                System.out.println(tables[i] + " : " + count);                
            } catch (SQLException e) {
                System.out.println("[Error] Cannot read the tables.");
            }

        }
    }

    //Admin operation end
    
    
    //User operation
    public void listCarByCallNum(String CallNum){
        try{
            PreparedStatement statement = connect.prepareStatement("SELECT callNum, carName, ccName, company, copyCount FROM car c, carCategory cc WHERE callNum = ? AND c.ccId = cc.ccId ORDER BY callNum");
            statement.setString(1, CallNum);
            ResultSet result = statement.executeQuery();

            System.out.println("|Call Num|Name|Car Category|Company|Available No. of Copy|");
            if(result.next()){
                String callNum = result.getString(1);
                String carName = result.getString(2);
                String ccName = result.getString(3);
                String company = result.getString(4);
                int copyCount = result.getInt(5);
                System.out.println("|" + callNum + "|" + carName + "|" + ccName + "|" + company + "|" + copyCount + "|");
            }else{
                System.out.println("No matching is found\n");
            }
        }catch(SQLException e){
            System.out.println("[Error] Cannot execute the query.\n");
        }catch(Exception e){
            System.out.println("[#Error]: " + e.toString());
        }
    }


    public void listCarByCarName(String CarName){
        try{
            PreparedStatement statement = connect.prepareStatement("SELECT callNum, carName, ccName, company, copyCount FROM car c, carCategory cc WHERE carName = ? AND c.ccId = cc.ccId ORDER BY callNum");
            statement.setString(1, CarName);
            ResultSet result = statement.executeQuery();

            System.out.println("|Call Num|Name|Car Category|Company|Available No. of Copy|");
            while(result.next()){
                String callNum = result.getString(1);
                String carName = result.getString(2);
                String ccName = result.getString(3);
                String company = result.getString(4);
                int copyCount = result.getInt(5);
                System.out.println("|" + callNum + "|" + carName + "|" + ccName + "|" + company + "|" + copyCount + "|");
            }
            System.out.println("End of Query\n");
        }catch(SQLException e){
            System.out.println("[Error] Cannot execute the query.\n");
        }catch(Exception e){
            System.out.println("[#Error]: " + e.toString());
        }
    }

    public void listCarByCompany(String Company){
        try{
            PreparedStatement statement = connect.prepareStatement("SELECT callNum, carName, ccName, company, copyCount FROM car c, carCategory cc WHERE company = ? AND c.ccId = cc.ccId ORDER BY callNum");
            statement.setString(1, Company);
            ResultSet result = statement.executeQuery();

            System.out.println("|Call Num|Name|Car Category|Company|Available No. of Copy|");
            while(result.next()){
                String callNum = result.getString(1);
                String carName = result.getString(2);
                String ccName = result.getString(3);
                String company = result.getString(4);
                int copyCount = result.getInt(5);
                System.out.println("|" + callNum + "|" + carName + "|" + ccName + "|" + company + "|" + copyCount + "|");
            }
            System.out.println("End of Query\n");
        }catch(SQLException e){
            System.out.println("[Error] Cannot execute the query.\n");
        }catch(Exception e){
            System.out.println("[#Error]: " + e.toString());
        }
    }

    public void listRentRecordByUID(String UID){
        try{
            System.out.println("Test1\n");
            PreparedStatement statement = connect.prepareStatement("SELECT r.callNum, copyNum, carName, company, checkout, return_date FROM rent r, car c WHERE uId = ? AND r.callNum = c.callNum ORDER BY checkout DESC");
            statement.setString(1, UID);
            ResultSet result = statement.executeQuery();


            System.out.println("Test2\n");
            System.out.println("|Call Num|CopyNum|Name|Company|Check-out|Returned?|");
            while(result.next()){
                String callNum = result.getString(1);
                int copyNum = result.getInt(2);
                String carName = result.getString(3);
                String company = result.getString(4);

                System.out.println("Test3\n");
                /*
                Calendar dateSource = Calendar.getInstance();
                dateSource.setTimeInMillis(result.getDate(5).getTime());
                String checkout = DataConvert.toString(dateSource)
                */



                String checkout = String.format("%1$tY-%1$tm-%1$td", result.getDate(5));
                String return_flag;
                if(result.getDate(6) != null){
                    return_flag = "Yes";
                }else{
                    return_flag = "No";
                }
                System.out.println("|" + callNum + "|" + copyNum + "|" + carName + "|" + company + "|" + checkout + "|" + return_flag + "|");
            }
            System.out.println("End of Query\n");
        }catch(SQLException e){
            System.out.println("[Error] Cannot execute the query.\n");
        }catch(Exception e){
            System.out.println("[#Error]: " + e.toString());
        }
    }
    
    //User operation end
    
    //
    /*
    public void rentCar(String usercred, String callnumber, int copynumber){
        try {
           
            PreparedStatement statement = connect.prepareStatement("SELECT * FROM  rent WHERE callNum = ? AND copyNum = ?");
            statement.setString(1, callnumber);
            statement.setInt(2, copynumber);
            if (!statement.executeQuery().next()) {
                System.out.println("The car does not exist. Please check that the CallNum and CopyNum are correct and retry.\n");
                return;
            }

            
            statement = connect.prepareStatement("SELECT * FROM user WHERE uId = ?");
            statement.setString(1, usercred);
            if (!statement.executeQuery().next()) {
                System.out.println("The user does not exist. Please check that the user ID is correct and retry.\n");
                return;
            }

            
            statement = connect.prepareStatement("SELECT * FROM rent WHERE callNum = ? AND copyNum = ? AND return_date IS NULL");
            statement.setString(1, callnumber);
            statement.setInt(2, copynumber);
            if (statement.executeQuery().next()) {
                System.out.println("The car was previously rented.\n");
                return;
            }

        
            statement = connect.prepareStatement("INSERT INTO rent (uId, callNum, copyNum, checkout, return_date) VALUES (?, ?, ?, ?, NULL)");
            statement.setString(1, usercred);
            statement.setString(2, callnumber);
            statement.setInt(3, copynumber);
            statement.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
            statement.execute();
            System.out.println("Car Renting performed successfully!!!\n");
        } catch (SQLException e) {
            System.out.println("Car renting was Unsuccesful.\n");
        }
    }


    public void returnCar(String usercred, String callnumber, int copynumber) {
        try {
            
            PreparedStatement statement = connect.prepareStatement("SELECT * FROM rent WHERE callNum = ? AND copyNum = ?");
            statement.setString(1, callnumber);
            statement.setInt(2, copynumber);
            if (!statement.executeQuery().next()) {
                System.out.println(" The car does not exist. Please check that the CallNumber and CopyNumber are correctly inputted and try again.\n");
                return;
            }

        
            statement = connect.prepareStatement("SELECT * FROM user WHERE uId = ?");
            statement.setString(1, usercred);
            if (!statement.executeQuery().next()) {
                System.out.println("The user does not exist. Please check that the user ID is correctly inputted and try again.\n");
                return;
            }

            // Check that this book is checked out by the user.
            statement = connect.prepareStatement("SELECT * FROM rent WHERE uId = ? AND callNum = ? AND copyNum = ? AND return_date IS NULL");
            statement.setString(1, usercred);
            stmt.setString(2, callnumber);
            stmt.setInt(3, copynumber);
            if (!statement.executeQuery().next()) {
                System.out.println("NO checkout record exists for the inputted information.\n");
                return;
            }

            statement = connect.prepareStatement("UPDATE rent  SET return_date = ? WHERE uId = ? AND callNum = ? AND copyNum = ? AND return_date IS NULL");
            statement.setDate(1, new Date(Calendar.getInstance().getTimeInMillis()));
            statement.setString(2, usercred);
            statement.setString(3, callnumber);
            statement.setInt(4, copynumber);
            statement.execute();
            System.out.println("Car returning performed successfully.\n");
        } catch (SQLException e) {
            System.out.println("The book return was Unsuccesful .\n");
        }
    }
    
    public void listAllUnreturnedCars(Calendar startDate, Calendar endDate) {
        try {
            PreparedStatement statement = connect.prepareStatement("SELECT uId, callNum, copyNum, checkout FROM rent WHERE checkout >= ? AND checkout <= ? AND ret IS NULL ORDER BY checkout DESC");
            statement.setDate(1, new Date(startDate.getTimeInMillis()));
            statement.setDate(2, new Date(endDate.getTimeInMillis()));
            ResultSet result = statement.executeQuery();

            System.out.println("|UID|CallNum|CopyNum|Checkout|");
            while (result.next()) {
                String userID = result.getString(1);
                String callnum = result.getString(2);
                int copynum = result.getInt(3);
                Calendar checkout = Calendar.getInstance();
                checkout.setTimeInMillis(result.getDate(4).getTime());
                System.out.println("|" + userID + "|" + callnum + "|" + copynum + "|" + DateConvert.toString(checkout) + "|");
            }
            System.out.println("End of Query\n");
        } catch (SQLException e) {
            System.out.println("The records couldnt be fetched properly.\n");
        }
    }
    
    */
    //





}
