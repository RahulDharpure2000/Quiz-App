/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DbConnection {
    private static Connection conn;
   static
        {
          try
          {
             Class.forName("oracle.jdbc.OracleDriver");
             conn = DriverManager.getConnection("jdbc:oracle:thin:@//Rahul-PC:1521/XE", "onlineexam", "exam");
             JOptionPane.showMessageDialog(null, "Connect successfully to the DB");
          } 
          catch (Exception ex)
          {
              JOptionPane.showMessageDialog(null, "Cannot connect to the DB");
               ex.printStackTrace();
              System.exit(1);
          }   
        }
   public static Connection getConn()
   { 
       return conn;
   }
   public static void closeConnection()
   {
     try
     {
       conn.close();
       JOptionPane.showMessageDialog(null, "Disconnect successfully to the DB");
     }
     catch(SQLException ex)
     {
      JOptionPane.showMessageDialog(null, "Cannot disconnect with the DB");
      ex.printStackTrace();   
     }
         
   }
}