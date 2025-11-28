package Project_QuizBuilder.entity;

import java.util.List;

public class Quiz { // đề tài câu hỏi
    private Integer id;
    private static Integer nextID = 0;
    private String title;
    private List<Questions> questions;

    public Quiz(String title) {
        this.id = ++nextID;
        this.title = title;
    }
    public Quiz(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
    public Quiz(List<Questions> questions) {
        this.questions = questions;
    }

    public Quiz() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
}
