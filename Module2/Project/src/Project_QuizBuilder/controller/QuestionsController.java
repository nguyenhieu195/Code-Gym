package Project_QuizBuilder.controller;

import Project_QuizBuilder.entity.Questions;
import Project_QuizBuilder.service.QuesService;
import Project_QuizBuilder.service.QuizService;

import java.util.List;

public class QuestionsController {

    private QuesService serviceQues;
    private QuizService serviceQuiz;

    public QuestionsController(QuesService serviceQues, QuizService serviceQuiz) {

        this.serviceQues = serviceQues;
        this.serviceQuiz = serviceQuiz;
    }

    public boolean add(Questions ques) throws Exception {

        return  serviceQues.add(ques);
    }

    public boolean remove(int id) throws Exception {

        return  serviceQues.remove(id);
    }

    public Questions findById(int id) throws Exception {

        return serviceQues.findById(id);
    }

    public boolean update(Questions ques) throws Exception {

        return serviceQues.update(ques);
    }

    public List<Questions> getListQuestions() {
        return serviceQues.getListQuestions();
    }
}
