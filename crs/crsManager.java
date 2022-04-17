package crs;

import java.sql.*;
import java.util.*;
import model.*;
public class crsManager implements CrsInterface
{
    private Database db;
    private Scanner sc;
    // Reference of DB
    public crsManager(Database db, Scanner sc){
        this.db = db;
        this.sc = sc;
    }
    

    // main

    public void startCRS(){
        while(true){
            printMenu();
            int input = sc.nextInt();

            switch(input){
                case 1:
                System.out.println("You choose Car Renting\n");
                carRenting();
                break;
                case 2:
                System.out.println("You choose car Returning \n");
                carReturning();
                break;
                case 3:
                System.out.println("You choose List all un-returned car\n");
                unReturnedCar();
                break;
                case 4:
                System.out.println("You choose return to main menu\n");
                break;
                default:
                System.out.println("Invalid operation, choose again\n");
            }
        }
    }

    private static void printMenu()
    {
        System.out.println("-----Operations for Manager menu----\n");
        System.out.println("What kinds of operations would you like to perform?\n");
        System.out.println("1. Car Renting\n");
        System.out.println("2. Car Returning\n");
        System.out.println("3. List all un-returned car copies which are checked-out within a period\n");
        System.out.println("4. Return to main menu\n");
        System.out.println("Enter Your Choice: \n");
    }

    private static void carReturning()
    {
         while(true){
            System.out.println("Enter the User ID:");
            String input1; = "";
            input += sc.nextLine();

            System.out.println("Enter the Call Number");
            String input2; = "";
            input += sc.nextLine();

            System.out.print("Enter the Copy Number");
            String input3; = "";
            input = sc.nextInt();

            System.out.println();
            
            try{
            db.returnCar(input1,input2,input3);
        }catch(Exception e){
            System.out.println("[ERROR]: " + e.toString());
        }
            
            
            System.out.println();
         }
    }

    private static void carRenting()
    {
         while(true){
            System.out.println("Enter the User ID:");
            String input1 = "";
            input += sc.nextLine();

            System.out.println("Enter the Call Number");
            String input2 = "";
            input += sc.nextLine();

            System.out.print("Enter the Copy Number");
            String input3 = "";
            input = sc.nextInt();

            System.out.println();
            
            try{
            db.returnCar(input1,input2,input3);
        }catch(Exception e){
            System.out.println("[ERROR]: " + e.toString());
        }
            
            
            System.out.println();
         }
    }
    private static void unReturnedCar() {
        Calender startingDate, endingDate;

        System.out.printf("Type in the starting date [dd/mm/yyyy]: ");
        startingDate = DateConvert.toCalendarSlash(sc.next());
        System.out.printf("Type in the ending date [dd/mm/yyyy]: ");
        endingDate = DateConvert.toCalendarSlash(sc.next());
        System.out.println();

        db.listAllUnreturnedCars(startingDate, endingDate);
    }
}
