package crs;

import java.util.*;
import java.sql.*;
import model.*;

public class crsAdmin implements CrsInterface{
    private Database db;
    private Scanner sc;

    public crsAdmin(Database db, Scanner sc){
        this.db = db;
        this.sc = sc;
    }

    public void startCRS(){
        while(true){
            printMenu();
            int input = sc.nextInt();

            switch(input){
                case 1:
                System.out.println("You choose Create All Table");
                createAllTable();
                break;
                case 2:
                System.out.println("You choose Delete All Table");
                deleteAllTable();
                break;
                case 3:
                System.out.println("You choose Load File To Database");
                loadFromDataFile();
                break;
                case 4:
                System.out.println("You choose Show No. of Record");
                showNumOfRecords();
                break;
                case 5:
                return;
                default:
                System.out.println("Invalid operation, choose again\n");
            }
        }
    }

    public void printMenu(){
        System.out.println("-----Main menu----");
        System.out.println("What kinds of operations would you like to perform?");
        System.out.println("1. Create all tables");
        System.out.println("2. Delete all tables");
        System.out.println("3. Load from datafile");
        System.out.println("4. Show number of records in each table");
        System.out.println("5. Return to main menu");
        System.out.print("Enter Your Choice: ");
    }

    //sql operation here

    private void createAllTable(){
        try{
            System.out.println("Processing...");
            db.creatAllTable();
            System.out.println("Done.Database is initialized.");
        }catch(SQLException e){
            if(e.toString().contains("exists")){
                System.out.println("[Error] Tables already created.");
            }else{
                System.out.println("[Error] Failed to create tables.");
            }
        }
        
    }

    private void deleteAllTable(){
        try{
            System.out.println("Processing...");
            db.deleteAllTable();
            System.out.println("Done! Database is removed!\n");
        }catch (SQLException e){
            if (e.toString().contains("Unknown")) {
                System.out.println("[Error] Tables do not exist.\n");
            } else {
                System.out.println("[Error] Failed to delete tables.\n");
            }
        }

    }

    private void loadFromDataFile(){
        System.out.printf("Type in the Source Data Folder Path: ");
        String folderPath = sc.next();
        try{
            System.out.println("Processing...");
            db.loadFromDataFile(folderPath);
            System.out.println("Done! Data is inputed to the database!\n");
        }catch(Exception e){
            System.out.println("[Error] Cannot load data from file.\n");
        }


    }

    private void showNumOfRecords(){
        System.out.println("Number of records in each table: \n");
        db.showNumOfRecords();
    }
}