/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import techquizapp.pojo.*;
import java.sql.SQLException;
import techquizapp.dbutil.DbConnection;

/**
 *
 * @author priya
 */
public class UserDao {
    public static boolean validateUser(User user) throws SQLException{
        Connection conn=DbConnection.getConn();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password=? and usertype=?");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    public static boolean registerStudent(User user)throws SQLException{
        Connection conn=DbConnection.getConn();
        PreparedStatement ps=conn.prepareStatement("insert into Users values(?,?,?)");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        int ans=ps.executeUpdate();
        return ans==1;
    }
    public static boolean changePassword(User user)throws SQLException{
        Connection conn=DbConnection.getConn();
        PreparedStatement ps=conn.prepareStatement("Update users set Password=? where UserId=?");
        
        ps.setString(1, user.getPassword());
        ps.setString(2, user.getUserId());
        int ans=ps.executeUpdate();
        return ans==1;
    }
}
