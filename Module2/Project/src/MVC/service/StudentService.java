package MVC.service;

import MVC.entity.Student;
import MVC.respository.StudentRespository;

import java.util.ArrayList;

public class StudentService implements IStudentService {
    StudentRespository studentRespository;

    public StudentService(StudentRespository studentRespository) {
        this.studentRespository = studentRespository;
    }

    @Override
    public void addStudent(Student student) {
        if (student.getId() == null) {
            System.out.println("Id khong duoc null");
            return;
        }
        if (studentRespository.findById(student.getId()) != null) {
            System.out.println("Id đã có");
            return;
        }
        studentRespository.addS(student);
        System.out.println("Da them thanh cong");
    }

    @Override
    public boolean removerStudent(int id) {
        boolean removed = studentRespository.removeByIdS(id);
        if(!removed){
            System.out.println("khong tim thay sinh vien de xoa");
            return removed;
        }
        System.out.println("Da xoa thanh cong");
        return removed;
    }

    @Override
    public boolean updateStudent(Student student) {
        if(student.getId() == null){
            System.out.println("Id khong duoc null");
            return false;
        }
        boolean updated = studentRespository.updateS(student);
        if(!updated){
            System.out.println("Khong the update do khong tim thay id");
            return updated;
        }
        System.out.println("Update thanh cong!");
        return updated;
    }

    @Override
    public ArrayList<Student> displayAllStudent() {
        return new ArrayList<>(studentRespository.findAll());
    }

    @Override
    public Student findByIdStudent(int id) {
        return studentRespository.findById(id);
    }
}
