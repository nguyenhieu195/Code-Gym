package mvc.service;

import mvc.entity.Student;
import mvc.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private StudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Student findById(int id) {
        return null;
    }
}
