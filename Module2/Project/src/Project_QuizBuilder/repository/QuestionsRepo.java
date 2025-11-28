package Project_QuizBuilder.repository;

import Project_QuizBuilder.entity.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionsRepo {
    private List<Questions> listQuestions;

    public QuestionsRepo() {
        listQuestions = new ArrayList<>();
    }

    public boolean checkQuesId(int id) {
        for (Questions questions : listQuestions) {
            if (questions.getId() == id) return true;
        }
        return false;
    }

    public Questions findById(int id) {
        for (Questions q : listQuestions) {
            if (q.getId() == id) return q;
        }
        return null;
    }

    public List<Questions> getListQuestions() {
        return listQuestions;
    }

    public void setListQuestions(List<Questions> listQuestions) {
        this.listQuestions = listQuestions;
    }

    public void add(Questions ques) {
        if (!checkQuesId(ques.getId())) {
            listQuestions.add(ques);
        }
    }

    public void removeById(int id) {
        listQuestions.removeIf(ques -> Objects.equals(ques.getId(), id));
    }

    public boolean update(Questions ques) {
        for (Questions q : listQuestions) {
            if (q.getId() == ques.getId()) {
                q.setContent(ques.getContent());
                q.setAnswer(ques.getAnswer());
                q.setCorrectIndex(ques.getCorrectIndex());
                q.setScore(ques.getScore());
                return true;
            }
        }
        return false;
    }
}
