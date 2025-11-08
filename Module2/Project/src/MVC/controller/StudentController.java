package MVC.controller;

import MVC.entity.Student;
import MVC.respository.StudentRespository;
import MVC.service.IStudentService;
import MVC.service.StudentService;

import java.util.ArrayList;

public class StudentController {
    StudentService StudentService;

    public StudentController(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    public void addStudent(Student student) {
        StudentService.addStudent(student);
    }

    public boolean removeStudent(int id) {
        return StudentService.removerStudent(id);
    }

    public boolean updateStudent(Student student) {
        return StudentService.updateStudent(student);
    }

    public ArrayList<Student> displayAllStudent() {
        return StudentService.displayAllStudent();
    }

    public Student findByIdStudent(int id) {
        return StudentService.findByIdStudent(id);
    }
}
