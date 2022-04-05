package crs;

import java.util.*;

public class crsMain implements CrsInterface {
    public void printMenu(){
        System.out.println("-----Main menu----\n");
        System.out.println("What kinds of operations would you like to perform?\n");
        System.out.println("1. Operations for Administrator\n");
        System.out.println("2. Operations for User\n");
        System.out.println("3. Operations for Manager\n");
        System.out.println("4. Exit this program\n");
    }

    public static void main(String args[]){
        crsMain c = new crsMain();
        c.printMenu();
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        switch (input){
            case 1 :
            System.out.println("You choose Admin\n");
            break;
            case 2 :
            System.out.println("You choose User\n");
            break;
            case 3 :
            System.out.println("You choose Manager\n");
            break;
            case 4 :
            System.out.println("You wanna leave\n");
            break;
            default :
            System.out.println("WDYM\n");
            
        }
    }
    
}