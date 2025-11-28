package Project_QuizBuilder.repository;

import Project_QuizBuilder.entity.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuizRepo {
    private List<Quiz> quizLists;

    public QuizRepo() {
        quizLists = new ArrayList<>();
    }

    public List<Quiz> getQuizLists() {
        return quizLists;
    }

    public boolean checkQuizId(int id) {
        for (Quiz quiz : quizLists) {
            if (quiz.getId() == id) return true;
        }
        return false;
    }

    public Quiz findById(int id) {
        for (Quiz q : quizLists) {
            if (q.getId() == id) return q;
        }
        return null;
    }

    public void add(Quiz quiz) {
        if (!checkQuizId(quiz.getId())) {
            quizLists.add(quiz);
        }
    }

    public void removeById(int id) {
        quizLists.removeIf(quiz -> Objects.equals(quiz.getId(), id));
    }

    public boolean updateQuiz(Quiz quiz) {
        for (Quiz q : quizLists) {
            if (q.getId() == quiz.getId()) {
                q.setTitle(quiz.getTitle());
                return true;
            }
        }
        return false;
    }


}