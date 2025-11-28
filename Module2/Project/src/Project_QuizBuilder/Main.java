package Project_QuizBuilder;

import Project_QuizBuilder.controller.QuestionsController;
import Project_QuizBuilder.controller.QuizController;
import Project_QuizBuilder.controller.QuizResultController;
import Project_QuizBuilder.controller.YourAnswerController;
import Project_QuizBuilder.repository.AnswerManagerRepo;
import Project_QuizBuilder.repository.QuestionsRepo;
import Project_QuizBuilder.repository.QuizRepo;
import Project_QuizBuilder.repository.QuizResultRepo;
import Project_QuizBuilder.service.QuesService;
import Project_QuizBuilder.service.QuizResultService;
import Project_QuizBuilder.service.QuizService;
import Project_QuizBuilder.service.YourAnswerService;
import Project_QuizBuilder.view.MainView;
import Project_QuizBuilder.view.QuesView;
import Project_QuizBuilder.view.QuizView;
import Project_QuizBuilder.view.WorkQuizView;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // ===== KHỞI TẠO REPO =====
        QuizRepo quizRepo = new QuizRepo();
        QuestionsRepo questionsRepo = new QuestionsRepo();
        QuizResultRepo quizResultRepo = new QuizResultRepo();
        AnswerManagerRepo answerManagerRepo = new AnswerManagerRepo();

        // ===== SERVICE =====
        QuizService quizService = new QuizService(questionsRepo, quizRepo);
        QuesService quesService = new QuesService(questionsRepo, quizRepo);
        QuizResultService quizResultService = new QuizResultService(quizResultRepo);
        YourAnswerService yourAnswerService = new YourAnswerService(answerManagerRepo);

        // ===== CONTROLLER =====
        QuizController quizController = new QuizController(quesService, quizService);
        QuestionsController questionsController = new QuestionsController(quesService, quizService);
        QuizResultController quizResultController = new QuizResultController(quizResultService);
        YourAnswerController yourAnswerController = new YourAnswerController(yourAnswerService);

        // ===== VIEW =====
        QuizView quizView = new QuizView(quizController, questionsController);
        QuesView quesView = new QuesView(quizController, questionsController);
        WorkQuizView workQuizView = new WorkQuizView(quizController, questionsController, quizResultController, yourAnswerController, quizView);

        // ===== MAIN VIEW =====
        MainView mainView = new MainView(quizView,workQuizView);
        mainView.menu();
    }
}