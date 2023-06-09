package bankmanagementsystem;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conn {

     Connection con;
     Statement stmt;
     public Conn(){
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root","sql@123");
            stmt=con.createStatement();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    
}
