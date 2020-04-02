package dbhandler;
import util.JavaSeH2Memory;
import util.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberService {

    private static final String URL = "jdbc:h2:file:./userDB;DB_CLOSE_DELAY=-1";
    private static final String SQL_INSERT_USER = "INSERT INTO users(name, password) VALUES('%s', '%s');";
    private static final String SQL_DELETE_USER = "DELETE FROM users WHERE name='%s' AND password='%s';";
    private static final String SQL_FIND_USER = "SELECT * FROM users WHERE name='%s' AND password='%s';";
    private static final String SQL_CREATE_USER_TABLE ="CREATE TABLE IF NOT EXISTS users(name VARCHAR(255) PRIMARY KEY, password VARCHAR(255));";
    private static final String SQL_CREATE_INFO_TABLE ="CREATE TABLE  IF NOT EXISTS info(name VARCHAR(255), last_name VARCHAR(255), Email VARCHAR(255), online BOOLEAN);";
    private static final String SQL_SHOW_TABLES = "SHOW TABLES;";

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
}
