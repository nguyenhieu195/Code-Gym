package Project_QuizBuilder.entity;

public class Answer {
    private Integer quesId ;
    private Integer selectIndex; // câu trả lời người dùng chọn

    public Answer() {
    }

    public Integer getQuesId() {
        return quesId;
    }

    public void setQuesId(Integer quesId) {
        this.quesId = quesId;
    }

    public Integer getSelectIndex() {
        return selectIndex;
    }

    public void setSelectIndex(Integer selectIndex) {
        this.selectIndex = selectIndex;
    }

    public Answer(Integer quesId, Integer selectIndex) {
        this.quesId = quesId;
        this.selectIndex = selectIndex;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "quesId=" + quesId +
                ", selectIndex=" + selectIndex +
                '}';
    }
}
