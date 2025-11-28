package Project_QuizBuilder.service;

import Project_QuizBuilder.entity.YourAnswer;
import Project_QuizBuilder.repository.AnswerManagerRepo;

import java.util.List;
import java.util.Objects;

public class YourAnswerService {
    private AnswerManagerRepo repoAns;

    public YourAnswerService() throws Exception {
        repoAns = new AnswerManagerRepo();
    }

    public boolean add(YourAnswer answer){
        repoAns.add(answer);
        return true;
    }

    public boolean delete(String user){
        repoAns.delete(user);
        return true;
    }

    public YourAnswer findByUsername(String username) throws Exception {
        YourAnswer answer = repoAns.findByUsername(username);
        if (answer == null) {
            throw new Exception("Your answer does not exist !");
        }
        return answer;
    }

    public YourAnswer findByID(int id) throws Exception {
        YourAnswer answer = repoAns.findByID(id);
        if (answer == null) {
            throw new Exception("Your answer does not exist !");
        }
        return answer;
    }
    public YourAnswer findByUserAndQuiz(String username, int quizId) throws Exception{
        YourAnswer answer = repoAns.findByUserAndQuiz(username, quizId);
        if (answer == null) {
            throw new Exception("Your answer does not exist !");
        }
        return answer;
    }
    public List<YourAnswer> getListAnswer() {
        return repoAns.getListAnswer();
    }
}
