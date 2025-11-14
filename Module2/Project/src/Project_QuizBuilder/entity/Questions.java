package Project_QuizBuilder.entity;

import java.util.Arrays;

public class Questions {
    private Integer id;
    private Integer quizId;
    private String content;
    private String[] answer;
    private Integer correctIndex; // vị trí câu trả lời đúng

    public Questions() {
    }

    public Questions(Integer id, Integer quizId, String content, String[] answer, Integer correctIndex) {
        this.id = id;
        this.quizId = quizId;
        this.content = content;
        this.answer = answer;
        this.correctIndex = correctIndex;
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
}
