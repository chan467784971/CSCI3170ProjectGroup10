import java.util.*;
import java.sql.*;
import crs.*;
import model.*;

//command
public class main
{
    public static void main(String args[])
    {
        //database connect
        Database db = new Database();

        if (db.Connect()){
            System.out.println("Database connected");
        }else{
            System.out.println("Database connect fail");
        }
        


        //start system
        System.out.println("Welcome to Car Renting System!\n");
        System.out.println("\n");

        crsMain crs = new crsMain(db);
        crs.startCRS();
    }
}
