package Project_QuizBuilder.service;

import Project_QuizBuilder.entity.Quiz;
import Project_QuizBuilder.entity.QuizResult;
import Project_QuizBuilder.repository.QuizResultRepo;

import java.util.List;

public class QuizResultService {

    private QuizResultRepo repoQuizResult;

    public QuizResultService(QuizResultRepo repoQuizResult) {
        this.repoQuizResult = repoQuizResult;
    }

    public boolean save(QuizResult quizResult) {
        repoQuizResult.save(quizResult);
        return true;
    }

    public boolean delete(int id) throws Exception {
        repoQuizResult.delete(id);
        if (repoQuizResult.findById(id) != null) {
            throw new Exception("Delete failure!");
        }
        return true;
    }

    public QuizResult findById(int id) throws Exception {
        QuizResult quizResult = repoQuizResult.findById(id);
        if (quizResult == null) {
            throw new Exception("Find Failure!");
        }
        return quizResult;
    }

    public QuizResult findByUsername(String name) {

        return repoQuizResult.findByUsername(name);
    }

    public List<QuizResult> getQuizResults() {
        return repoQuizResult.getQuizResults();
    }
}
