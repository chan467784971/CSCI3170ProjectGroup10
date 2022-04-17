package crs;

import java.util.*;
import model.*;

public class crsMain implements CrsInterface {
    private Database db;
    private Scanner sc;

    public crsMain(Database db){
        this.db = db;
        this.sc = new Scanner(System.in);
    }

    private void printMenu(){
        System.out.println("-----Main menu----\n");
        System.out.println("What kinds of operations would you like to perform?\n");
        System.out.println("1. Operations for Administrator\n");
        System.out.println("2. Operations for User\n");
        System.out.println("3. Operations for Manager\n");
        System.out.println("4. Exit this program\n");
    }

    public void startCRS(){
        while(true){
            printMenu();
            int input = sc.nextInt();
            System.out.println();
            CrsInterface c = null;

            switch (input){
                case 1 :
                System.out.println("You choose Admin\n");
                c = new crsAdmin(db, sc);
                break;
                case 2 :
                System.out.println("You choose User\n");
                c = new crsUser(db, sc);
                break;
                case 3 :
                System.out.println("You choose Manager\n");
                break;
                case 4 :
                System.out.println("You wanna leave\n");
                return;
                default :
                System.out.println("Invalid operation, choose again\n");
            }

            if (c != null){
                c.startCRS();
            }
        }

    }

    
}
