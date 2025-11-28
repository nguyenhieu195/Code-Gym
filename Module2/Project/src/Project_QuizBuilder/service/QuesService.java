package Project_QuizBuilder.service;

import Project_QuizBuilder.entity.Questions;
import Project_QuizBuilder.repository.QuestionsRepo;
import Project_QuizBuilder.repository.QuizRepo;

import java.util.List;

public class QuesService implements   IService<Questions> {

    private QuestionsRepo repoQues;
    private QuizRepo repoQuiz;

    public QuesService(QuestionsRepo repoQues, QuizRepo quizRepo) {

        this.repoQues = repoQues;
        this.repoQuiz = quizRepo;
    }

    public boolean add(Questions ques) throws Exception {

        if (repoQues.findById(ques.getId()) != null) {
            throw new Exception("ID does not exist !");
        }
        repoQues.add(ques);
        return true;
    }

    public boolean remove(int id) throws Exception {

        if (repoQues.findById(id) == null) {
            throw new Exception("ID does not exist !");
        }
        repoQues.removeById(id);
        return true;
    }

    public Questions findById(int id) throws Exception {

        Questions ques = repoQues.findById(id);
        if (ques == null) {
            throw new Exception("ID does not exist !");
        }
        return ques;
    }

    public boolean update(Questions ques) throws Exception {

        if (repoQues.findById(ques.getId()) == null) {
            throw new Exception("ID does not exist !");
        }
        return repoQues.update(ques);
    }

    public List<Questions> getListQuestions() {
        return repoQues.getListQuestions();
    }
}
