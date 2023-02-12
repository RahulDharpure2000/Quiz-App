/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

public class Exam {
    private String ExamId;
    private String Language;
    private int NoOfQuestions;

    public String getExamId() {
        return ExamId;
    }

    public void setExamId(String ExamId) {
        this.ExamId = ExamId;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public int getNoOfQuestions() {
        return NoOfQuestions;
    }

    public void setNoOfQuestions(int NoOfQuestions) {
        this.NoOfQuestions = NoOfQuestions;
    }

    public Exam(String ExamId, String Language, int NoOfQuestions) {
        this.ExamId = ExamId;
        this.Language = Language;
        this.NoOfQuestions = NoOfQuestions;
    }

    public Exam() {
    }
}
