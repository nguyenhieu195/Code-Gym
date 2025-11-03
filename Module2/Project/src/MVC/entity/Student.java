package MVC.entity;

import java.time.LocalDate;

public class Student {
    private Integer id;
    private String name;
    private LocalDate dob;
    private Float score;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Student(Integer id, String name, LocalDate dob, Float score) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", score=" + score +
                '}';
    }
}
