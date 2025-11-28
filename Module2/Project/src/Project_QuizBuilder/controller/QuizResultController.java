package Project_QuizBuilder.controller;

import Project_QuizBuilder.entity.QuizResult;
import Project_QuizBuilder.service.QuizResultService;

import java.util.List;

public class QuizResultController {

    private QuizResultService service;

    public QuizResultController(QuizResultService service) {
        this.service = service;
    }

    public boolean save(QuizResult quizResult) {
        return service.save(quizResult);
    }

    public boolean delete(int id) throws Exception {
        return service.delete(id);
    }

    public QuizResult findById(int id) throws Exception {
        return service.findById(id);
    }
    public QuizResult findByUsername(String name)  {
        return service.findByUsername(name);
    }
    public List<QuizResult> getQuizResults() throws Exception {
        return service.getQuizResults();
    }
}
