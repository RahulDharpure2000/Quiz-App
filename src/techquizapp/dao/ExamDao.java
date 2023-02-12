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
import techquizapp.pojo.Exam;


public class ExamDao 
{
        public static String getExamId() throws SQLException{
            Connection conn=DbConnection.getConn();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select count(*) from Exam");
            rs.next();
            int count=rs.getInt(1);
            String newId="EX-"+(count+1);
            return newId;
        }
        public static boolean addExam(Exam exam)throws SQLException{
            Connection conn=DbConnection.getConn();
            PreparedStatement ps=conn.prepareStatement("insert into Exam values(?,?,?)");
            ps.setString(1, exam.getExamId());
            ps.setString(2, exam.getLanguage());
            ps.setInt(3, exam.getNoOfQuestions());
            int ans=ps.executeUpdate();
            return ans==1;
        }
        public static ArrayList<String> getExamIdBySubject(String subject)throws SQLException{
            Connection conn=DbConnection.getConn();
            System.out.println("subject at dao" +subject);
            PreparedStatement  ps=conn.prepareStatement("select ExamId from Exam where language=?");
            ps.setString(1, subject);
            ResultSet rs=ps.executeQuery();
            ArrayList<String> examIdList=new  ArrayList<>();
            while(rs.next()){
                System.out.println("examid"+rs.getString(1));
                examIdList.add(rs.getString(1));
            }
            return examIdList;
        }
        public static int getQueCountByExamId(String examId)throws SQLException{
            Connection conn=DbConnection.getConn();
            PreparedStatement  ps=conn.prepareStatement("select TOTAL_QUESTION from Exam where ExamId=?");
            ps.setString(1, examId);
            ResultSet rs=ps.executeQuery();
            rs.next();
            return  rs.getInt(1);
       }
        public static boolean isPaperSet(String subject)throws SQLException{
            Connection conn=DbConnection.getConn();
            PreparedStatement ps=conn.prepareStatement("select examId from exam where Language=?");
            ps.setString(1, subject);
            ResultSet rs=ps.executeQuery();
            return rs.next();
        }
        
        public static ArrayList<String> getExamIdBySubject(String userId,String subject)throws SQLException{
            Connection conn=DbConnection.getConn();
            PreparedStatement ps=conn.prepareStatement("Select ExamId from Exam where Language=? minus select Examid from Performance where UserId=?");
            ps.setString(1, subject);
            ps.setString(2, userId);
            ResultSet rs=ps.executeQuery();
            ArrayList<String> examIdList=new  ArrayList<>();
            while(rs.next()){
                System.out.println("examid"+rs.getString(1));
                examIdList.add(rs.getString(1));
            }
            return examIdList;
        }
    
    
}
