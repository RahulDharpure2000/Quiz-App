/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;


public class Performance {
    private String userId;
    private String examId;
    private int right;
    private int wrong;
    private int unAttempted;
    private double percentage;
    private String subject;

    public Performance() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public int getUnAttempted() {
        return unAttempted;
    }

    public void setUnAttempted(int unAttempted) {
        this.unAttempted = unAttempted;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Performance(String userId, String examId, int right, int wrong, int unAttempted, double percentage, String subject) {
        this.userId = userId;
        this.examId = examId;
        this.right = right;
        this.wrong = wrong;
        this.unAttempted = unAttempted;
        this.percentage = percentage;
        this.subject = subject;
    }
    
    
    
}
