package MVC.service;

import MVC.entity.Student;

import java.util.ArrayList;

public interface IStudentService {
    void addStudent(Student student);
    boolean removerStudent(int id);
    boolean updateStudent(Student student);
    ArrayList<Student> displayAllStudent();
    Student findByIdStudent(int id);

}
