package crs;

import java.util.*;
import java.sql.*;
import model.*;

public class crsUser implements CrsInterface{
    private Database db;

    
    // Reference of DB
    public void MainCrs(Database db){
        this.db = db;
    }
    

    // main
    public void main(){
        while(true){
            System.out.println("-----Operations for user menu-----\n");
            System.out.println("What kind of operation would you like to perform?\n");
            System.out.println("1. Search for Cars\n");
            System.out.println("2. Show loan record of a user\n");
            System.out.println("3. Return to the main menu\n");
            System.out.print("Enter Your Choice: ");

            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            
            System.out.println();

            switch(input){
                case 1:
                    searchCar();
                    break;
                case 2:
                    showRecord();
                    break;
                case 3:
                    System.out.println("Return to main menu\n");
                    return;
                default:
                    System.out.println("Invalid operation, choose again\n");
            }
        }
    }


    // searchCar
    public void searchCar() {
        while(true){
            System.out.println("Choose the Search criterion:\n");
            System.out.println("1. call number\n");
            System.out.println("2. name\n");
            System.out.println("3. company\n");
            System.out.print("Choose the search criterion: ");

            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            
            System.out.println();

            switch(input){
                case 1:
                    searchByCallNumber();
                    break;
                case 2:
                    searchByCarName();
                    break;
                case 3:
                    searchByCompany();
                    break;
                default:
                    System.out.println("Invalid operation, choose again\n");
            }
        }
    }

    
    public void searchByCallNumber() {
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
        
        /*
        System.out.print("Type in the Call Number: ");
        Scanner in = new Scanner(System.in);
        String input = "";
        input += in.nextLine();
        
        System.out.println();

        try{
            db.listCarByCallNum(input);
        }catch(Exception e){
            System.out.println("[*ERROR]: " + e.toString());
        }
        */
    }

    public void searchByCarName() {
        System.out.print("Type in the Search Keyword: ");
        Scanner in = new Scanner(System.in);
        String input = "";
        input += in.nextLine();
        
        System.out.println();

        try{
            db.listCarByCarName(input);
        }catch(Exception e){
            System.out.println("[*ERROR]: " + e.toString());
        }
    }

    public void searchByCompany() {
        System.out.print("Type in the Search Keyword: ");
        Scanner in = new Scanner(System.in);
        String input = "";
        input += in.nextLine();
        
        System.out.println();

        try{
            db.listCarByCompany(input);
        }catch(Exception e){
            System.out.println("[*ERROR]: " + e.toString());
        }
    }

    public void showRecord() {
        System.out.print("Enter The cuser ID: ");
        Scanner in = new Scanner(System.in);
        String input = "";
        input += in.nextLine();
        
        System.out.println();
        
        try{
            db.listRentRecordByUID(input);
        }catch(Exception e){
            System.out.println("[*ERROR]: " + e.toString());
        }
    }
}
