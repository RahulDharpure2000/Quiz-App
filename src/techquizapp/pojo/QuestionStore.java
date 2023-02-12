package techquizapp.pojo;
import java.util.ArrayList;
public class QuestionStore {
    ArrayList<Question> QuestionList;
    public QuestionStore() {
        QuestionList=new ArrayList<>();
    }
    public void addQuestion(Question question){
        QuestionList.add(question);
    }
    public ArrayList<Question> getAllQuestion(){
        return QuestionList;
    }
    public int getCount(){
        return QuestionList.size();
    }
    public Question getQuestion(int pos){
        return QuestionList.get(pos);
    }
    public void removeQuestion(int pos){
        QuestionList.remove(pos);
    }
    public void setQuestionAt(int pos,Question q){
        QuestionList.add(pos, q);
    }

    @Override
    public String toString() {
        return "QuestionStore{" + "QuestionList=" + QuestionList + '}';
    }
    
}
