package Project_QuizBuilder.entity;

import java.util.Arrays;

public class Questions {
    private Integer id;
    private String content;
    private String[] answer;
    private Integer correctIndex; // vị trí câu trả lời đúng

    public Questions() {
    }

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", answer=" + Arrays.toString(answer) +
                ", correctIndex=" + correctIndex +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Questions(Integer id, String content, String[] answer, Integer correctIndex) {
        this.id = id;
        this.content = content;
        this.answer = answer;
        this.correctIndex = correctIndex;
    }
}
