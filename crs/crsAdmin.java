package crs;

import java.util.*;
import java.sql.*;
import model.*;

public class crsAdmin implements CrsInterface{
    private Database db;

    public void MainCrs(Database db){
        this.db = db;
    }

    public void startCrs(){
        while(true){
            printMenu();
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();

            switch(input){
                case 1:
                System.out.println("You choose Create\n");
                break;
                case 2:
                System.out.println("You choose Delete\n");
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

    public void printMenu(){
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
}