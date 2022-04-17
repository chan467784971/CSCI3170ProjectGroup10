package crs;

import java.sql.*;
import java.util.*;
import model.*;
public class Manager implements CrsInterface
{
    private Database db;
    private String callNumber;
    private String userId;
    private String copyNumber;
    //Initialization
    public void MainCrs(Database db){
        this.db = db;
    }
    Manager(String callNumber,String userId,String copyNumber)
    {
        this.callNumber=callNumber;
        this.userId=userId;
        this.copyNumber=copyNumber;
    }
    

    public void main(){
        while(true){
            printMenu();
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();

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

    private static void carRenting()
    {
        Scanner in = new Scanner(System.in);
         while(true){
            System.out.println("Enter the User ID:");
            System.out.print("Type in the Call Number: ");
           String input1; = "";
            input += in.nextLine();

            System.out.println("Enter the Call Number");
            String input2; = "";
            input += in.nextLine();

            System.out.print("Enter the Copy Number");
            String inpu3; = "";
            input = in.nextInt();
            
            //db.(sadasdsahjdasjdnsahjdj) (input1, input2, input3);
            
            
            System.out.println();
//    	int flag=0;
        // connect to db and make changes
    	
    	
    	
//    	String sql="";
    	//Connection con=new Connection();
    	//Statement stmt=con.createStatement();
//    	if(stmt.execute(sql)) {
//    	String sqlTemp="";
//    	stmt.executeQuery(sqlTemp);
//    	flag=1;
//    	}
//    	else {
//    	String sqlTemp="";
//    	stmt.executeQuery(sqlTemp);
        
//    	}
//    	if(flag==1) {
//    		System.out.println("Yes, car is available you can rent it");
//    	}
//    	else {
//    		System.out.println("Sorry!!! Car is not available");
//    	}
    }
    private static void carReturning()
    {
        //connect to db and make changes
    	
    	
    	
    	//Connection con=new Connection();
    	//Statement stmt=con.createStatement();
    	//String sql="";
//    	if(stmt.execute(sql)) {
//    	System.out.println("Yes,You can return your car");
//    	String sql2="";
//    	stmt.executeUpdate(sql2);	
//    	}
//    else {
//    System.out.println("Sorry for inconvenience but your request can't be process");	
//    }
    }
    private static void unReturnedCar()
    {
        //connect to db and serach of unreturned status.
    	
    	//Connection con=new Connection();
    	//Statement stmt=con.createStatement();
//    	String displayUnreturnedCarsql = "";
//		ResultSet rs = c.s.executeQuery(String displayUnreturnedCarsql);
//    	System.out.println(rs);
    }

}
