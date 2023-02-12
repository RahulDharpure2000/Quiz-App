/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DbConnection;
import techquizapp.pojo.Performance;
import techquizapp.pojo.StudentScore;

/**
 *
 * @author priya
 */
public class PerformanceDao {
    public static void addPerformance(Performance performance)throws SQLException{
        String qry="insert into Performance values(?,?,?,?,?,?,?)";
        Connection conn=DbConnection.getConn();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, performance.getUserId());
        ps.setString(2, performance.getExamId());
        ps.setInt(3, performance.getRight());
        ps.setInt(4, performance.getWrong());
        ps.setInt(5, performance.getUnAttempted());
        ps.setDouble(6, performance.getPercentage());
        ps.setString(7, performance.getSubject());
        ps.executeUpdate();
    }
    public static ArrayList<String> getAllStudentId()throws SQLException
    {
       String qry="select distinct userid from performance";
       ArrayList<String> studentIdList=new ArrayList<>();
       Connection conn=DbConnection.getConn();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery(qry);
           
           while(rs.next()){
               String id=rs.getString(1);
               studentIdList.add(id);
           }
               
    return studentIdList;                      
   }
   public static ArrayList<String> getAllExamId(String studentId)throws SQLException
    {
       String qry="select examid from performance where userid=?";
       ArrayList<String> examIdList=new ArrayList<>();
       Connection conn=DbConnection.getConn();
       PreparedStatement ps=conn.prepareStatement(qry);
       ps.setString(1, studentId);
       ResultSet rs=ps.executeQuery();
        while(rs.next()){
               String id=rs.getString(1);
               examIdList.add(id);
           }
    return examIdList;                      
   }
   public static StudentScore getScore(String studentId,String examId)throws SQLException
   {
        String qry="Select language,per from Performance where userid=? and examid=?";
        Connection conn=DbConnection.getConn();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,studentId);
        ps.setString(2,examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        StudentScore scoreObj=new StudentScore();
        scoreObj.setLanguage(rs.getString(1));
        scoreObj.setPer(rs.getDouble(2));
        return scoreObj;
    }
   public static ArrayList<Performance> getAllData() throws SQLException{
        Connection conn=DbConnection.getConn();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from Performance order by UserId");
        ArrayList<Performance> performanceList=new ArrayList<>();
        while(rs.next()){
            Performance p=new Performance(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getDouble(6),rs.getString(7));
            performanceList.add(p);
        }
        return performanceList;
    }
}
