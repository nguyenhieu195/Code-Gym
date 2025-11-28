package Project_QuizBuilder.service;

public interface IService<T> {
    boolean add(T t) throws Exception;

    boolean remove(int id) throws Exception;

    T findById(int id) throws Exception;

    boolean update(T t) throws Exception;
}
