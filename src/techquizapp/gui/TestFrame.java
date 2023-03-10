/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.gui;

import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import techquizapp.dao.PerformanceDao;
import techquizapp.dao.QuestionDao;
import techquizapp.pojo.Answer;
import techquizapp.pojo.AnswerStore;
import techquizapp.pojo.Exam;
import techquizapp.pojo.Performance;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.UserProfile;

/**
 *
 * @author Rahul Dharpure
 */
public class TestFrame extends javax.swing.JFrame {

    /**
     * Creates new form TestFrame
     */
    private Color lblOldcolor;
    private Exam exam;
    private QuestionStore qstore;
    private int pos=0,qno;
    private AnswerStore astore;
    public TestFrame() {
        initComponents();
        setLocationRelativeTo(null);
        lblUser.setText("Hello "+UserProfile.getUserName());
        jtaQuestion.setEditable(false);
        qstore=new QuestionStore();
        astore=new AnswerStore();
    }
    public TestFrame(Exam exam) {
         this();
         this.exam=exam;
         lblPaper.setText(exam.getLanguage().toUpperCase()+" Paper");
         lblTotalTime.setText(lblTotalTime.getText()+(exam.getNoOfQuestions()/2)+" mins");
         TestFrame.TimerThread tt=new TestFrame.TimerThread();
         tt.start();
         loadQuestion();
         showQuestion();
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
        private void loadQuestion() {
        try{
           
            ArrayList<Question> questionList=QuestionDao.getQuestionByExamId(exam.getExamId());
            System.out.println(questionList.size());
            for(Question ques:questionList){
                qstore.addQuestion(ques);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
             JOptionPane.showMessageDialog(null, "Some problem occured t db EPF Error","DB Error",JOptionPane.ERROR_MESSAGE);
    }
    }

    private void showQuestion() {
       Question q=qstore.getQuestion(pos);
       buttonGroup1.clearSelection();
       jtaQuestion.setText(q.getQuestion());
       jrbOption1.setText(q.getAnswer1());
       jrbOption2.setText(q.getAnswer2());
       jrbOption3.setText(q.getAnswer3());
       jrbOption4.setText(q.getAnswer4());
       qno=q.getQno();
       lblQueNo.setText("Question no:"+qno);
       Answer ans=astore.getAnswerByQno(qno);
       if(ans==null){
           return;
       }
       String chsnAns=ans.getChosenAnswer();
       switch(chsnAns){
            case "Answer1":
               jrbOption1.setSelected(true); break;
            case "Answer2":
               jrbOption2.setSelected(true); break;
            case "Answer3":
               jrbOption3.setSelected(true); break;
            case "Answer4":
               jrbOption4.setSelected(true); break;
       }
         
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblPaper = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTotalTime = new javax.swing.JLabel();
        lblTimeTaken = new javax.swing.JLabel();
        lblQueNo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaQuestion = new javax.swing.JTextArea();
        jrbOption1 = new javax.swing.JRadioButton();
        jrbOption2 = new javax.swing.JRadioButton();
        jrbOption4 = new javax.swing.JRadioButton();
        jrbOption3 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnCencel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 51));

        lblPaper.setBackground(new java.awt.Color(0, 0, 0));
        lblPaper.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblPaper.setForeground(new java.awt.Color(255, 255, 51));
        lblPaper.setText("PAPER");

        lblLogout.setBackground(new java.awt.Color(0, 0, 0));
        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 51));
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techquizapp/gui/good luck2.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        lblTotalTime.setBackground(new java.awt.Color(0, 0, 0));
        lblTotalTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotalTime.setForeground(new java.awt.Color(255, 255, 51));
        lblTotalTime.setText("Total Time : ");

        lblTimeTaken.setBackground(new java.awt.Color(0, 0, 0));
        lblTimeTaken.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTimeTaken.setForeground(new java.awt.Color(255, 255, 51));
        lblTimeTaken.setText("Taken Time:");

        lblQueNo.setBackground(new java.awt.Color(0, 0, 0));
        lblQueNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQueNo.setForeground(new java.awt.Color(255, 255, 51));
        lblQueNo.setText("Question No:");

        jtaQuestion.setColumns(20);
        jtaQuestion.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jtaQuestion.setRows(5);
        jScrollPane1.setViewportView(jtaQuestion);

        jrbOption1.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbOption1);
        jrbOption1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrbOption1.setForeground(new java.awt.Color(255, 255, 51));

        jrbOption2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbOption2);
        jrbOption2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrbOption2.setForeground(new java.awt.Color(255, 255, 51));

        jrbOption4.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbOption4);
        jrbOption4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrbOption4.setForeground(new java.awt.Color(255, 255, 51));

        jrbOption3.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbOption3);
        jrbOption3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrbOption3.setForeground(new java.awt.Color(255, 255, 51));

        btnNext.setBackground(new java.awt.Color(0, 0, 0));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 51));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(0, 0, 0));
        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(255, 255, 51));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnCencel.setBackground(new java.awt.Color(0, 0, 0));
        btnCencel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCencel.setForeground(new java.awt.Color(255, 255, 51));
        btnCencel.setText("Cancel");
        btnCencel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCencelActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(0, 0, 0));
        btnDone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDone.setForeground(new java.awt.Color(255, 255, 51));
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnCencel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQueNo))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTimeTaken, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(lblTotalTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jrbOption1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addComponent(jrbOption3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jrbOption2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addComponent(jrbOption4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(lblPaper, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(lblLogout)
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogout)
                            .addComponent(lblPaper))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblTotalTime, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTimeTaken, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQueNo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jrbOption2)
                    .addComponent(jrbOption1))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbOption4)
                    .addComponent(jrbOption3))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDone)
                    .addComponent(btnCencel)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        LoginFrame loginFrame=new LoginFrame();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        lblLogout.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        lblLogout.setForeground(lblOldcolor);
    }//GEN-LAST:event_lblLogoutMouseExited

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        nextQues();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        String chosenAnswer=getChosenAnswer();
        System.out.println("choosen ans is btnNext "+chosenAnswer);
        if(chosenAnswer!=null){
            Question ques=qstore.getQuestion(pos);
            String correctAns=ques.getCorrectAnswer();
            System.out.println("coerret ans from ques is "+correctAns);
            Answer answer=new Answer(exam.getExamId(), exam.getLanguage(), qno, chosenAnswer, correctAns);
            Answer attemptedPreviously=astore.getAnswerByQno(qno);
            if(attemptedPreviously==null){
               astore.addAnswer(answer);
            }
            else{
               String prevAnswer=attemptedPreviously.getChosenAnswer();
               if(prevAnswer.equals(chosenAnswer)==false){
                   int apos=astore.removeAnswer(attemptedPreviously);
                   astore.setAnswerAt(apos, answer);   
               }
            }
        }
        System.out.println("astore for check "+astore);
     
       
        pos--;
        if(pos<0){
            pos=qstore.getCount()-1;
        }
        showQuestion();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnCencelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCencelActionPerformed
       StudentOptionsFrame  studentOptionsFrame=new StudentOptionsFrame();
        studentOptionsFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCencelActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        doneClick();
    }//GEN-LAST:event_btnDoneActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCencel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbOption1;
    private javax.swing.JRadioButton jrbOption2;
    private javax.swing.JRadioButton jrbOption3;
    private javax.swing.JRadioButton jrbOption4;
    private javax.swing.JTextArea jtaQuestion;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblPaper;
    private javax.swing.JLabel lblQueNo;
    private javax.swing.JLabel lblTimeTaken;
    private javax.swing.JLabel lblTotalTime;
    private javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
 private String getChosenAnswer() {
        if(jrbOption1.isSelected())
            return "Answer1";
        else if(jrbOption2.isSelected())
            return "Answer2";
        else if(jrbOption3.isSelected())
            return "Answer3";
        else if(jrbOption4.isSelected())
            return "Answer4";
        else 
            return null;
              
    }

    private void nextQues() {
        String chosenAnswer=getChosenAnswer();
        System.out.println("choosen ans is btnNext "+chosenAnswer);
        if(chosenAnswer!=null){
            Question ques=qstore.getQuestion(pos);
            String correctAns=ques.getCorrectAnswer();
            System.out.println("coerret ans from ques is "+correctAns);
            Answer answer=new Answer(exam.getExamId(), exam.getLanguage(), qno, chosenAnswer, correctAns);
            Answer attemptedPreviously=astore.getAnswerByQno(qno);
            if(attemptedPreviously==null){
               astore.addAnswer(answer);
            }
            else{
               String prevAnswer=attemptedPreviously.getChosenAnswer();
               if(prevAnswer.equals(chosenAnswer)==false){
                   int apos=astore.removeAnswer(attemptedPreviously);
                   astore.setAnswerAt(apos, answer);   
               }
               
            }
               
            
        }
        System.out.println("astore for check "+astore);
        pos++;
        if(pos>=qstore.getCount()){
            pos=0;
        }
        
        showQuestion();

    }

    private void doneClick() {
        String userName=UserProfile.getUserName();
        String chosenAnswer=getChosenAnswer();
        
        if(chosenAnswer!=null){
            Question ques=qstore.getQuestion(pos);
            String correctAns=ques.getCorrectAnswer();
            System.out.println("coerret ans from ques is "+correctAns);
            Answer answer=new Answer(exam.getExamId(), exam.getLanguage(), qno, chosenAnswer, correctAns);
            Answer attemptedPreviously=astore.getAnswerByQno(qno);
            if(attemptedPreviously==null){
               astore.addAnswer(answer);
            }
            else{
                String prevAnswer=attemptedPreviously.getChosenAnswer();
                if(prevAnswer.equals(chosenAnswer)==false){
                    int apos=astore.removeAnswer(attemptedPreviously);
                    astore.setAnswerAt(apos, answer);   
               }
            }
        }
        System.out.println("astore for check "+astore);
        int right=0,wrong=0;
        for(Question ques:qstore.getAllQuestion()){
            int quesno=ques.getQno();
            Answer ans=astore.getAnswerByQno(quesno);
            if(ans==null){
                continue;
            }
            String attemptedAnswer=ans.getChosenAnswer();
            String correctAnswer=ans.getCorrectAnswer();
            if(correctAnswer.equals(attemptedAnswer))
                right++;
            else 
                wrong++;
        }
            StringBuilder sb=new StringBuilder();
            sb.append("\nRight answers: ").append(right);
            sb.append("\nWrong answers: "+wrong);
            sb.append("\nUnattempted answers: "+(qstore.getCount()-(right +wrong)));
            
            double percentage=(double)right/qstore.getCount()*100;
            JOptionPane.showMessageDialog(null, sb.toString(),"result",JOptionPane.INFORMATION_MESSAGE);
            try{
                Performance performance=new Performance(userName, exam.getExamId(), right, wrong,qstore.getCount()-(right +wrong) , percentage, exam.getLanguage());
                PerformanceDao.addPerformance(performance);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Some problem occured t db EPF Error","DB Error at perfadd",JOptionPane.ERROR_MESSAGE);
            }
            StudentOptionsFrame studentOptionsFrame=new StudentOptionsFrame();
            studentOptionsFrame.setVisible(true);
            this.dispose();
        
        
    }
    class TimerThread extends Thread{
        
        @Override
        public void run(){
            int min=00;
            int sec=00;
            DecimalFormat decimalFormat=new DecimalFormat("00");
            
            lblTimeTaken.setText("Taken Time-"+decimalFormat.format(min)+":"+decimalFormat.format(sec));
            while(min<(exam.getNoOfQuestions()/2)){
                try {
                sec++;
                if(sec>=60){
                    min++;
                    sec=00;
                }
                if(sec==30){
                    nextQues();
                }
                lblTimeTaken.setText("Taken Time-"+decimalFormat.format(min)+":"+decimalFormat.format(sec));
                
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Intrrupted thread","Interrupted ex",JOptionPane.ERROR_MESSAGE);
                }
            }
            doneClick();
            
            
        }
        
    }
}
