package mvc.service;

import mvc.entity.Person;
import mvc.entity.Student;

import java.util.List;

public interface IService<T extends Person> {
    List<T> findAll();

    Boolean save(T t);

    void update(T t);

    void delete(int id);

    T findById(int id);
}
