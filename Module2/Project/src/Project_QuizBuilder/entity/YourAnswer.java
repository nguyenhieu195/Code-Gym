package Project_QuizBuilder.entity;

public class YourAnswer {
    private Integer id;
    private static Integer nextID = 0;
    private String username;
    private Quiz  quiz;
    private QuizResult quizResult;

    public YourAnswer(String username, Quiz quiz, QuizResult quizResult) {
        this.id = ++nextID;
        this.username = username;
        this.quiz = quiz;
        this.quizResult = quizResult;
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

    public QuizResult getQuizResult() {
        return quizResult;
    }

    public void setQuizResult(QuizResult quizResult) {
        this.quizResult = quizResult;
    }
}


