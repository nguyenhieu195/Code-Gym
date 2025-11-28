package Project_QuizBuilder.service;

import Project_QuizBuilder.entity.Quiz;
import Project_QuizBuilder.repository.QuestionsRepo;
import Project_QuizBuilder.repository.QuizRepo;

import java.util.List;

public class QuizService implements IService<Quiz> {

    private QuestionsRepo repoQues;
    private QuizRepo repoQuiz;

    public QuizService(QuestionsRepo repoQues, QuizRepo repoQuiz) {

        this.repoQues = repoQues;
        this.repoQuiz = repoQuiz;
    }

    public boolean add(Quiz quiz) throws Exception {

        if (repoQuiz.findById(quiz.getId()) != null) {
            throw new Exception("ID does not exist !");
        }
        repoQuiz.add(quiz);
        return true;
    }

    public boolean remove(int id) throws Exception {

        if (repoQuiz.findById(id) == null) {
            throw new Exception("ID does not exist !");
        }
        repoQuiz.removeById(id);
        return true;
    }

    public Quiz findById(int id) throws Exception {

        Quiz quiz = repoQuiz.findById(id);
        if (quiz == null) {
            throw new Exception("ID does not exist !");
        }
        return quiz;
    }

    public boolean update(Quiz q) throws Exception {

        if (repoQuiz.findById(q.getId()) == null) {
            throw new Exception("ID does not exist !");
        }
        return repoQuiz.updateQuiz(q);
    }

    public List<Quiz> getListQuiz() {
        return repoQuiz.getQuizLists();
    }
}
