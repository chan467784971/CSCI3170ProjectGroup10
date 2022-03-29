import java.sql.*;

public class DataBase {
    private String dbAddress = "jdbc:mysql://projgw.cse.cuhk.edu.hk:2633/db10";
    private String dbUsername = "Group10";
    private String dbPassword = "CSCI3170";
    private Connection connect = null;

    // Operation
    public boolean Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connect = DriverManager.getConnection(dbAddress, dbUsername, dbPassword);
        } catch(ClassNotFoundException e) {
            System.out.println("[Error]: Java MySQL DB Driver not found!!!");
            return false;
        } catch(SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public void creatTable(String[] argument) {
        // preparedstatement ???????
    }

    public void dropTable(String[] argument) {

    }

    public void showSchema(String[] argument) {

    }

    public void insertRecord(String[] argument) {

    }

    public void updateRecord(String[] argument) {

    }

    public void deleteRecord(String[] argument) {

    }

    





}