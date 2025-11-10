package mvc.repository;

import mvc.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private  static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "HaiTT", LocalDate.now(), 9.8f));
        students.add(new Student(2, "HaiTT", LocalDate.now(), 9.8f));
        students.add(new Student(3, "HaiTT", LocalDate.now(), 9.8f));
        students.add(new Student(4, "HaiTT", LocalDate.now(), 9.8f));
    }

    public List<Student> findAll() {
        return students;
    }
}
