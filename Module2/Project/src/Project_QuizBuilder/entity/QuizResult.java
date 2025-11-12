package Project_QuizBuilder.entity;

import java.util.List;

public class QuizResult { // kết quả bài làm
    private String username;
    private Quiz quiz;
    private Integer correctCount;
    private List<Answer> answers;
    private Float score;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(Integer correctCount) {
        this.correctCount = correctCount;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public QuizResult() {
    }

    public QuizResult(String username, Quiz quiz, Integer correctCount, List<Answer> answers, Float score) {
        this.username = username;
        this.quiz = quiz;
        this.correctCount = correctCount;
        this.answers = answers;
        this.score = score;
    }

    @Override
    public String toString() {
        return "QuizResult{" +
                "username='" + username + '\'' +
                ", quiz=" + quiz +
                ", correctCount=" + correctCount +
                ", answers=" + answers +
                ", score=" + score +
                '}';
    }
}
