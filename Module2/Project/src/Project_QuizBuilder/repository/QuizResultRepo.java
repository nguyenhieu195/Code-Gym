package Project_QuizBuilder.repository;

import Project_QuizBuilder.entity.QuizResult;

import java.util.ArrayList;
import java.util.List;

public class QuizResultRepo {

    private List<QuizResult> quizResults;

    public  QuizResultRepo() {
        quizResults = new ArrayList<>();
    }

    public List<QuizResult> getQuizResults() {
        return quizResults;
    }

    public void save(QuizResult quizResult) {
        quizResults.add(quizResult);
    }

    public void delete(int id){
        for (QuizResult quizResult : quizResults) {
            if(quizResult.getId() == id){
                quizResults.remove(quizResult);
            }
        }
    }

    public QuizResult findById(int id){
        for (QuizResult quizResult : quizResults) {
            if(quizResult.getId() == id){
                return quizResult;
            }
        }
        return null;
    }

    public QuizResult findByUsername(String name){
        for (QuizResult quizResult : quizResults) {
            if(quizResult.getUsername().equals(name)){
                return quizResult;
            }
        }
        return null;
    }
}
