package MVC.respository;

import MVC.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRespository {
    private static ArrayList<Student> students = new ArrayList<>();

    public void addS(Student student) {
        students.add(student);
    }

    public boolean removeByIdS(int id) {
        return students.removeIf(student -> student.getId() == id && student.getId() != null);
    }

    public boolean updateS(Student student) {
        if (student.getId() == null) return false;
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getId() == null && s.getId().equals(student.getId())) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public Student findById(int id) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == id) return student;
        }
        return null;
    }

    public List<Student> findAll(){
        return new ArrayList<>(students);
    }
}
