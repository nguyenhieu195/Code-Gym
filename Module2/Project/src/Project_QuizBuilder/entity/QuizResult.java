package Project_QuizBuilder.entity;

public class QuizResult { // kết quả bài làm
    private Integer id;
    private static Integer nextID = 0;
    private String username;
    private Quiz quiz;
    private Integer correctCount; // số đáp án đúng
    private Float sumScore;

    public QuizResult(String username, Quiz quiz, Integer correctCount, Float sumScore) {
        this.id = ++nextID;
        this.username = username;
        this.quiz = quiz;
        this.correctCount = correctCount;

        this.sumScore = sumScore;
    }

    @Override
    public String toString() {
        return "QuizResult{" +
                "id=" + id +
                ", nextID=" + nextID +
                ", username='" + username + '\'' +
                ", quiz=" + quiz +
                ", correctCount=" + correctCount +
                ", score=" + sumScore +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNextID() {
        return nextID;
    }

    public void setNextID(Integer nextID) {
        this.nextID = nextID;
    }

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


    public Float getSumScore() {
        return sumScore;
    }

    public void setSumScore(Float sumScore) {
        this.sumScore = sumScore;
    }
}
