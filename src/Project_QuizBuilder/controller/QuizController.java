package Project_QuizBuilder.controller;

import Project_QuizBuilder.entity.Quiz;
import Project_QuizBuilder.service.QuesService;
import Project_QuizBuilder.service.QuizService;

import java.util.List;

public class QuizController {


    private QuizService serviceQuiz;

    public QuizController() throws Exception {

        serviceQuiz = new QuizService();
    }

    public boolean add(Quiz quiz) throws Exception {

        return serviceQuiz.add(quiz);
    }

    public boolean remove(int id) throws Exception {

        return serviceQuiz.remove(id);
    }

    public Quiz findById(int id) throws Exception {

        return serviceQuiz.findById(id);
    }

    public boolean update(Quiz q) throws Exception {

        return serviceQuiz.update(q);
    }

    public List<Quiz> getListQuiz() {
        return serviceQuiz.getListQuiz();
    }
}
