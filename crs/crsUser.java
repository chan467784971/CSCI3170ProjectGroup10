package crs;

import java.util.*;
import java.sql.*;
import model.*;

public class crsUser implements CrsInterface{
    private Database db;
    private Scanner sc;

    
    // Reference of DB
    public crsUser(Database db, Scanner sc){
        this.db = db;
        this.sc = sc;
    }
    

    // main
    public void startCRS(){
        while(true){
            System.out.println("-----Operations for user menu-----");
            System.out.println("What kind of operation would you like to perform?");
            System.out.println("1. Search for Cars");
            System.out.println("2. Show loan record of a user");
            System.out.println("3. Return to the main menu");
            System.out.print("Enter Your Choice: ");

            int input = sc.nextInt();
            
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
    private void searchCar() {
        while(true){
            System.out.println("Choose the Search criterion:");
            System.out.println("1. call number");
            System.out.println("2. name");
            System.out.println("3. company");
            System.out.print("Choose the search criterion: ");

            int input = sc.nextInt();
            
            System.out.println();

            switch(input){
                case 1:
                    searchByCallNumber();
                    return;
                case 2:
                    searchByCarName();
                    return;
                case 3:
                    searchByCompany();
                    return;
                default:
                    System.out.println("Invalid operation, choose again\n");
            }
        }
    }

    
    private void searchByCallNumber() {
        System.out.print("Type in the Call Number: ");
        Scanner in = new Scanner(System.in);
        String input = "";
        input += in.nextLine();
        
        System.out.println();
        try{
            db.listCarByCallNum(input);
        }catch(Exception e){
            System.out.println("[ERROR]: " + e.toString());
        }
    }

    private void searchByCarName() {
        System.out.print("Type in the Search Keyword: ");
        Scanner in = new Scanner(System.in);
        String input = "";
        input += in.nextLine();
        
        System.out.println();

        try{
            db.listCarByCarName(input);
        }catch(Exception e){
            System.out.println("[ERROR]: " + e.toString());
        }
    }

    private void searchByCompany() {
        System.out.print("Type in the Search Keyword: ");
        Scanner in = new Scanner(System.in);
        String input = "";
        input += in.nextLine();
        
        System.out.println();

        try{
            db.listCarByCompany(input);
        }catch(Exception e){
            System.out.println("[ERROR]: " + e.toString());
        }
    }

    private void showRecord() {
        System.out.print("Enter the user ID: ");
        Scanner in = new Scanner(System.in);
        String input = "";
        input += in.nextLine();
        
        System.out.println();
        
        try{
            db.listRentRecordByUID(input);
        }catch(Exception e){
            System.out.println("[ERROR]: " + e.toString());
        }
    }
}
