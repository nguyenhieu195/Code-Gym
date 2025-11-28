package mvc.controller;

import mvc.entity.Student;
import mvc.service.IStudentService;
import mvc.service.StudentService;

import java.util.List;

public class StudentController {

    private IStudentService studentService = new StudentService();


    public List<Student> findAll() {
        return studentService.findAll();
    }

    public boolean add(Student student) {
        return studentService.save(student);
    }
}
