package Project_QuizBuilder.entity;

import java.util.Arrays;

public class Questions {
    private Integer id;
    private static Integer nextID = 0;
    private Integer quizId;
    private String content;
    private String[] answer;
    private Integer correctIndex; // vị trí câu trả lời đúng
    private Float score;

    public Questions() {
    }

    public Questions(Integer quizId, String content, String[] answer, Integer correctIndex , Float score) {
        this.id = ++nextID;
        this.quizId = quizId;
        this.content = content;
        this.answer = answer;
        this.correctIndex = correctIndex;
        this.score = score;

    }

    public Questions(Integer id, Integer quizId, String content, String[] answer, Integer correctIndex, Float score) {
        this.id = id;
        this.quizId = quizId;
        this.content = content;
        this.answer = answer;
        this.correctIndex = correctIndex;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuizId() {
        return quizId;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public Integer getCorrectIndex() {
        return correctIndex;
    }

    public void setCorrectIndex(Integer correctIndex) {
        this.correctIndex = correctIndex;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", quizId=" + quizId +
                ", content='" + content + '\'' +
                ", answer=" + Arrays.toString(answer) +
                ", correctIndex=" + correctIndex +
                '}';
    }
    public static Integer getNextID() {
        return nextID;
    }

    public static void setNextID(Integer nextID) {
        Questions.nextID = nextID;
    }
}
