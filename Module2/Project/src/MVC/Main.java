package MVC;

import MVC.controller.StudentController;
import MVC.respository.StudentRespository;
import MVC.service.IStudentService;
import MVC.service.StudentService;
import MVC.view.StudentView;

public class Main {
    public static void main(String[] args) {
        StudentRespository repository = new StudentRespository();
        IStudentService service = new StudentService(repository);
        StudentController controller = new StudentController(service);
        StudentView view = new StudentView(controller);

        view.menu();
    }
}