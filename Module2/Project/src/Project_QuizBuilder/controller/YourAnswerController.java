package Project_QuizBuilder.controller;

import Project_QuizBuilder.entity.YourAnswer;
import Project_QuizBuilder.service.YourAnswerService;

import java.util.List;

public class YourAnswerController {

    private YourAnswerService service;

    public YourAnswerController(YourAnswerService service) {
        this.service = service;
    }

    public boolean add(YourAnswer answer) {
        return service.add(answer);
    }

    public boolean delete(String user){
        return service.delete(user);
    }

    public YourAnswer findByUsername(String username) throws Exception {
        return service.findByUsername(username);
    }

    public YourAnswer findByID(int id) throws Exception {
        return service.findByID(id);
    }

    public List<YourAnswer> getListAnswer() {
        return service.getListAnswer();
    }
}
