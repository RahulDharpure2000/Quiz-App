 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

import java.util.Objects;

public class Question {
    private String ExamId;
    private int Qno;
    private String Question;
    private String Answer1,Answer2,Answer3,Answer4;
    private String CorrectAnswer;
    
    private String language;

    public Question(String ExamId, int Qno, String Question, String Answer1, String Answer2, String Answer3, String Answer4, String CorrectAnswer, String language) {
        this.ExamId = ExamId;
        this.Qno = Qno;
        this.Question = Question;
        this.Answer1 = Answer1;
        this.Answer2 = Answer2;
        this.Answer3 = Answer3;
        this.Answer4 = Answer4;
        this.CorrectAnswer = CorrectAnswer;
        this.language = language;
    }

   

    public Question() {
    }

    public String getExamId() {
        return ExamId;
    }

    public void setExamId(String ExamId) {
        this.ExamId = ExamId;
    }

    public int getQno() {
        return Qno;
    }

    public void setQno(int Qno) {
        this.Qno = Qno;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAnswer1() {
        return Answer1;
    }

    public void setAnswer1(String Answer1) {
        this.Answer1 = Answer1;
    }

    public String getAnswer2() {
        return Answer2;
    }

    public void setAnswer2(String Answer2) {
        this.Answer2 = Answer2;
    }

    public String getAnswer3() {
        return Answer3;
    }

    public void setAnswer3(String Answer3) {
        this.Answer3 = Answer3;
    }

    public String getAnswer4() {
        return Answer4;
    }

    public void setAnswer4(String Answer4) {
        this.Answer4 = Answer4;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String CorrectAnswer) {
        this.CorrectAnswer = CorrectAnswer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    @Override
    public String toString() {
        return "Question{" + "ExamId=" + ExamId + ", Qno=" + Qno + ", language=" + language + ", Answer1=" + Answer1 + ", Answer2=" + Answer2 + ", Answer3=" + Answer3 + ", Answer4=" + Answer4 + ", CorrectAnswer=" + CorrectAnswer + ", Question=" + Question + '}';
    }

  
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (this.Qno != other.Qno) {
            return false;
        }
        if (!Objects.equals(this.ExamId, other.ExamId)) {
            return false;
        }
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        if (!Objects.equals(this.Answer1, other.Answer1)) {
            return false;
        }
        if (!Objects.equals(this.Answer2, other.Answer2)) {
            return false;
        }
        if (!Objects.equals(this.Answer3, other.Answer3)) {
            return false;
        }
        if (!Objects.equals(this.Answer4, other.Answer4)) {
            return false;
        }
        if (!Objects.equals(this.CorrectAnswer, other.CorrectAnswer)) {
            return false;
        }
        if (!Objects.equals(this.Question, other.Question)) {
            return false;
        }
        return true;
    }
    
}
