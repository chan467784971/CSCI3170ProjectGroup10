package crs;

import java.util.*;
import java.sql.*;
import model.*;

public class crsAdmin implements CrsInterface{
    private Database db;

    public void MainCrs(Database db){
        this.db = db;
    }

    public void main(){
        while(true){
            printMenu();
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();

            switch(input){
                case 1:
                System.out.println("You choose Create\n");
                createAllTable();
                break;
                case 2:
                System.out.println("You choose Delete\n");
                deleteAllTable();
                break;
                case 3:
                System.out.println("You choose Loadfile\n");
                break;
                case 4:
                System.out.println("You choose Show\n");
                break;
                case 5:
                return;
                default:
                System.out.println("Invalid operation, choose again\n");
            }
        }
    }

    private void printMenu(){
        System.out.println("-----Main menu----\n");
        System.out.println("What kinds of operations would you like to perform?\n");
        System.out.println("1. Create all tables\n");
        System.out.println("2. Delete all tables\n");
        System.out.println("3. Load from datafile\n");
        System.out.println("4. Show number of records in each table\n");
        System.out.println("5. Return to main menu\n");
        System.out.println("Enter Your Choice: \n");
    }

    //sql operation here

    private void createAllTable(){
        try{
            System.out.println("Processing");
            db.creatAllTable();
            System.out.println("Done.Database is initialized.\n");
        }catch(SQLException e){
            if(e.toString().contains("exists")){
                System.out.println("[Error] Tables already created.\n");
            }else{
                System.out.println("[Error] Failed to create tables.\n");
            }
        }
        
    }

    private void deleteAllTable(){
        try{
            System.out.println("Processing");
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

    }

    private void showNumOfRecords(){

    }
}