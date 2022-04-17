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
            printMenu();
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();

            switch(input){
                case 1:
                searchCar();
                break;
                case 2:
                showNumOfRecords();
                //showRecord();
                break;
                case 3:
                System.out.println("Return to main menu\n");
                return;
                default:
                System.out.println("Invalid operation, choose again\n");
            }
        }
    }


    public void printMenu(){
        System.out.println("-----Operations for user menu-----\n");
        System.out.println("What kind of operation would you like to perform?\n");
        System.out.println("1. Search for Cars\n");
        System.out.println("2. Show loan record of a user\n");
        System.out.println("3. Return to the main menu\n");
        System.out.println("Enter Your Choice: \n");
    }


    // searchCar
    private void searchCar() {
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
    
    
    private void searchByCallNumber() {
        System.out.println("Number of records in each table: \n");
        db.showNumOfRecords();
        
        /*
        System.out.print("Type in the Call Number: ");
        Scanner in = new Scanner(System.in);
        String input = "";
        input += in.nextLine();
        
        System.out.println(input);// test add input
        try{
            db.listCarByCallNum(input);
        }catch(Exception e){
            System.out.println("[*ERROR]: " + e.toString());
        }
        */
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
            System.out.println("[*ERROR]: " + e.toString());
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
            System.out.println("[*ERROR]: " + e.toString());
        }
    }


    private void showRecord() {
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


    //testing
    private void showNumOfRecords(){
        System.out.println("Number of records in each table: \n");
        db.showNumOfRecords();
    }
}
