package util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberService {

    private static final String URL = "jdbc:h2:file:./userDB;DB_CLOSE_DELAY=-1";
    private static final String SQL_INSERT_USER = "INSERT INTO customers(id, name) VALUES('%s', '%s');";
    private static final String SQL_DELETE_USER = "DELETE FROM customers WHERE id='%s' AND name='%s';";
    private static final String SQL_FIND_USER = "SELECT * FROM customers WHERE id='%s' AND name='%s';";
    //private static final String SQL_CREATE_USER_TABLE ="CREATE TABLE IF NOT EXISTS users(name VARCHAR(255) PRIMARY KEY, password VARCHAR(255));";
    private static final String SQL_CREATE_CUSTOMER_TABLE ="CREATE TABLE IF NOT EXISTS customers(id VARCHAR(255) PRIMARY KEY, name VARCHAR(255));";
   // private static final String SQL_CREATE_INFO_TABLE ="CREATE TABLE  IF NOT EXISTS info(name VARCHAR(255), last_name VARCHAR(255), Email VARCHAR(255), online BOOLEAN);";
    private static final String SQL_SHOW_TABLES = "SHOW TABLES;";


    public MemberService() throws SQLException {
        DriverManager.registerDriver(org.h2.Driver.load());
        //createCustomerTable();
    }

    public boolean createCustomerTable(){
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(SQL_CREATE_CUSTOMER_TABLE);
            return rs>0;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JavaSeH2Memory.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }
/*
    public boolean createUserTable() {

        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(SQL_CREATE_USER_TABLE);
            return rs>0;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JavaSeH2Memory.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;

    }

    public boolean createInfoTable() {

        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(SQL_CREATE_INFO_TABLE);

            return rs>0;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JavaSeH2Memory.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;

    }
*/

    public boolean delete(Member member) {

        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(String.format(SQL_DELETE_USER,member.getName(),member.getPersonalNumber()));
            return rs>0;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JavaSeH2Memory.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }

    /******  Call db to register a new member *****
     * If member is already registered, return false.
     * Else proceed to register the member.
     *********************************************/
    public boolean registerMember(Member member) {
        if(!find(member))
            return false;
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(String.format(SQL_INSERT_USER,member.getName(),member.getPersonalNumber()));
            return rs>0;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JavaSeH2Memory.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }

    public boolean find(Member member) {
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(String.format(SQL_FIND_USER, member.getName(), member.getPersonalNumber()));

            if(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JavaSeH2Memory.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }

    public void readRecord(String tableName, String item) {
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();

            System.out.println("Reading data from " + tableName);
            stm = con.createStatement();
            String sql = "SELECT " + item + " FROM " + tableName;
            ResultSet rs = stm.executeQuery(sql);

            // STEP 4: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                String name = rs.getString("name");
                String pass = rs.getString("password");

                // Display values
                System.out.print("User : " + name);
                System.out.print("--> Password : " + pass);
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
