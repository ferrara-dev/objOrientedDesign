package util;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaSeH2Memory {

    public static void main(String[] args) throws SQLException {

        try {
            MemberService memberService = new MemberService();
            Member member = new Member("Samuel", "19940412-1395");
            //memberService.createTable();
            //memberService.insertRecord();

            //response = memberService.createUserTable();
         //   System.out.println(response);
           // userService.readRecord("users");
            //UserInfo info = new UserInfo("testare", "testare@hotmail.gay", "12345");
         //  response = userService.save(info);
           // System.out.println(response);
           // response = userService.find(info);
           // System.out.println(response);
            //response = userService.delete(info);
            //System.out.println(response);
            //response = userService.find(info);
            //System.out.println(response);
            memberService.readRecord("customers","id, name");
           // userService.readRecord("info");
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaSeH2Memory.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}

