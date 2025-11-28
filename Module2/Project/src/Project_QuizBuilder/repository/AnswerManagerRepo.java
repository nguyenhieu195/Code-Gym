package Project_QuizBuilder.repository;

import Project_QuizBuilder.entity.YourAnswer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnswerManagerRepo {

    private List<YourAnswer> listAnswer;

    public AnswerManagerRepo() {
        listAnswer = new ArrayList<>();
    }

    public List<YourAnswer> getListAnswer() {
        return listAnswer;
    }

    public void add(YourAnswer answer){
        listAnswer.add(answer);
    }

    public void delete(String user){
//        listAnswer.remove(id);
        listAnswer.removeIf(answer -> answer.getUsername().equals(user));
    }

    public YourAnswer findByUsername(String username){
        for (YourAnswer answer : listAnswer) {
            if(Objects.equals(answer.getUsername(), username)){
                return answer;
            }
        }
        return null;
    }
    public YourAnswer findByID(int id){
        for (YourAnswer answer : listAnswer) {
            if(answer.getId() == id){
                return answer;
            }
        }
        return null;
    }
}
