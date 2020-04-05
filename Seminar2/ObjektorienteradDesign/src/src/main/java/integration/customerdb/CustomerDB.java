package integration.customerdb;

import util.JavaSeH2Memory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDB {
    private static final String URL = "jdbc:h2:file:./userDB;DB_CLOSE_DELAY=-1";
    private static final String INSERT_MULTIPLE_USERS_SQL = "INSERT INTO  CustomerDB " +
            "VALUES ('940412-1395', 'Samuel', 'samuel@gmail.com', 'India', '123')," +
            "('960404-6541', 'Deepa', 'deepa@gmail.com', 'India', '123')," + "('711231-6325', 'Tom', 'top@gmail.com', 'India', '123');";
    private static final String SQL_FIND_USER = "SELECT * FROM CustomerDB WHERE id='%s';";
    private static final String SQL_FIND_USERNAME = "SELECT * FROM CustomerDB *;";
    public static boolean find(String customerId) {
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(String.format(SQL_FIND_USER, customerId));

            if(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return false;
    }

    public static void readRecord(String tableName, String item,String key) {
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();

            System.out.println("Reading data from " + tableName);
            stm = con.createStatement();
            String sql = "SELECT " + item + " FROM " + tableName + " WHERE id='%s'";
            ResultSet rs = stm.executeQuery(String.format(sql,key));

            // STEP 4: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                String name = rs.getString("name");
                // Display values
                System.out.print("User : " + name);
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static List<String> getInformation(String operation){
        List<String> result = new ArrayList<>();
        switch (operation){
            case "name":{
                try (Connection con = DriverManager.getConnection(URL)){
                    Statement stm = con.createStatement();
                    stm = con.createStatement();
                    String sql1 = "SELECT NAME FROM CustomerDB";
                    ResultSet rs = stm.executeQuery(sql1);


                    // STEP 4: Extract data from result set
                    while (rs.next()) {
                        // Retrieve by column name
                        String name = rs.getString("name");
                        result.add(name);
                        // Display values
                        System.out.print("User : " + name);
                        System.out.println();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return result;
            }
            case "id":{
                try (Connection con = DriverManager.getConnection(URL)){
                    Statement stm = con.createStatement();
                    stm = con.createStatement();
                    String sql1 = "SELECT ID FROM CustomerDB";
                    ResultSet rs = stm.executeQuery(sql1);


                    // STEP 4: Extract data from result set
                    while (rs.next()) {
                        // Retrieve by column name
                        String name = rs.getString("id");
                        result.add(name);
                        // Display values
                        System.out.print("User : " + name);
                        System.out.println();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return result;
            }
        }

      return result;
    }


    public static void insertRecord() throws SQLException {
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager
                .getConnection(URL);

             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            int result = statement.executeUpdate(INSERT_MULTIPLE_USERS_SQL);
            System.out.println("No. of records affected : " + result);
        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        }
    }


    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
