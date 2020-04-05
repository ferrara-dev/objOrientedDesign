package startup;

import controller.Controller;
import integration.RegestryCreator;
import model.discountmodel.DiscountEngine;
import util.JavaSeH2Memory;
import util.Member;
import view.cashierview.CashierGui;
import view.cashierview.CashierView;
import view.View;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws Exception {
        CustomerDBCreator.createTable();
        RegestryCreator creator = new RegestryCreator();
        creator.createItemRegestry();
        creator.createDiscountRegestry();
        start(creator);

    }


    private static void start(RegestryCreator creator) throws Exception {
        View cashierView = new CashierView(new Controller(creator));
        testSale(((CashierView) cashierView));
    }

    private static void testSale(CashierView cashierView){
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    CashierGui cashierGui = new CashierGui(cashierView);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private static class CustomerDBCreator {
        private static final String URL = "jdbc:h2:file:./userDB;DB_CLOSE_DELAY=-1";
        private static final String createTableSQL = "create table IF NOT EXISTS CustomerDB(\r\n" + "  id  varchar(20) primary key,\r\n" +
                "  name varchar(20),\r\n" + "  email varchar(20),\r\n" + "  country varchar(20),\r\n" +
                "  password varchar(20)\r\n" + "  );";
        private static final String INSERT_MULTIPLE_USERS_SQL = "INSERT INTO  CustomerDB " +
                "VALUES ('940412-1395', 'Samuel', 'samuel@gmail.com', 'India', '123')," +
                "('960404-6541', 'Deepa', 'deepa@gmail.com', 'India', '123')," + "('711231-6325', 'Tom', 'top@gmail.com', 'India', '123');";
        private static final String SQL_FIND_USER = "SELECT * FROM CustomerDB WHERE id='%s';";

        public static void createTable() throws SQLException {

            System.out.println(createTableSQL);
            // Step 1: Establishing a Connection
            try (Connection connection = DriverManager
                    .getConnection(URL);

                 // Step 2:Create a statement using connection object
                 Statement statement = connection.createStatement();) {

                // Step 3: Execute the query or update query
                statement.execute(createTableSQL);
            } catch (SQLException e) {

                // print SQL exception information
                printSQLException(e);
            }

            // Step 4: try-with-resource statement will auto close the connection.
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
}



