package MVC.controller;

import MVC.entity.Student;
import MVC.respository.StudentRespository;
import MVC.service.IStudentService;

import java.util.ArrayList;

public class StudentController {
    IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    public void addStudent(Student student) {
        iStudentService.addStudent(student);
    }

    public boolean removeStudent(int id) {
        return iStudentService.removerStudent(id);
    }

    public boolean updateStudent(Student student) {
        return iStudentService.updateStudent(student);
    }

    public ArrayList<Student> displayAllStudent() {
        return iStudentService.displayAllStudent();
    }

    public Student findByIdStudent(int id) {
        return iStudentService.findByIdStudent(id);
    }
}
