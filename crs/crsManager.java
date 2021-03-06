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
                System.out.println("You choose Car Renting");
                carRenting();
                break;
                case 2:
                System.out.println("You choose car Returning");
                carReturning();
                break;
                case 3:
                System.out.println("You choose List all un-returned car");
                unReturnedCar();
                break;
                case 4:
                System.out.println("You choose return to main menu");
                return;
                default:
                System.out.println("Invalid operation, choose again");
            }
        }
    }

    private void printMenu()
    {
        System.out.println("-----Operations for Manager menu----");
        System.out.println("What kinds of operations would you like to perform?");
        System.out.println("1. Car Renting");
        System.out.println("2. Car Returning");
        System.out.println("3. List all un-returned car copies which are checked-out within a period");
        System.out.println("4. Return to main menu");
        System.out.println("Enter Your Choice: ");
    }

   private void carReturning()
    {
        Scanner in = new Scanner(System.in);
        
            
            
            System.out.print("Enter the User ID:");
            String input1="";
            input1 += in.nextLine();

            System.out.print("Type in the Call Number: ");
            String input2 = "";
            input2 += in.nextLine();

            System.out.print("Enter the Copy Number:");
            int input3;
            input3 = in.nextInt();

            System.out.println();
            
            try{
            db.returnCar(input1,input2,input3);
        }catch(Exception e){
            System.out.println("[ERROR]: " + e.toString());
        }
            
            
            System.out.println();
       
    }

    private void carRenting()
    {
        Scanner in = new Scanner(System.in);
        
            System.out.print("Enter the User ID:");
            String input1="";
            input1 += in.nextLine();

            System.out.print("Type in the Call Number: ");
            String input2 = "";
            input2 += in.nextLine();

            System.out.print("Enter the Copy Number");
            int input3;
            input3 = in.nextInt();

            System.out.println();
            
            try{
            db.rentCar(input1,input2,input3);
        }catch(Exception e){
            System.out.println("[ERROR]: " + e.toString());
        }
            
            
            System.out.println();
        
    }
    private void unReturnedCar() {
        Calendar startingDate, endingDate;
        //String startingDate = "", endingDate = "";
        //Scanner in = new Scanner(System.in);

        System.out.printf("Type in the starting date [dd/mm/yyyy]: ");
        //startingDate+=in.nextLine();
        startingDate = DataConvert.toCalendarSlash(sc.next());
        System.out.printf("Type in the ending date [dd/mm/yyyy]: ");
        //endingDate+=in.nextLine();
        //endingDate = DataConvert.toCalendarSlash(sc.next());
        endingDate = DataConvert.toCalendarSlash(sc.next());
        System.out.println();

        db.listAllUnreturnedCars(startingDate, endingDate);
    }
}
