package mvc.entity;

import java.time.LocalDate;

public class Student extends Person {

    private Float score;

    public Student( ) {

    }


    public Student(Integer id, String name, LocalDate dob, Float score) {
        super(id, name, dob);
        this.score = score;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }


}
