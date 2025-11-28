package Project_QuizBuilder;

import Project_QuizBuilder.controller.*;
import Project_QuizBuilder.entity.Account;
import Project_QuizBuilder.repository.*;
import Project_QuizBuilder.service.QuesService;
import Project_QuizBuilder.service.QuizResultService;
import Project_QuizBuilder.service.QuizService;
import Project_QuizBuilder.service.YourAnswerService;
import Project_QuizBuilder.view.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // ===== CONTROLLER =====
        QuizController quizController = null;
        QuestionsController questionsController = null;
        QuizResultController quizResultController = null;
        YourAnswerController yourAnswerController = null;

        try {
            quizController = new QuizController();
            questionsController = new QuestionsController();
            quizResultController = new QuizResultController();
            yourAnswerController = new YourAnswerController();

        } catch (Exception e) {
            System.out.println("ERROR initializing controllers: " + e.getMessage());
            return; // hoặc System.exit(0)
        }

        // ===== VIEW =====
        QuizView quizView = new QuizView(quizController, questionsController);
        QuesView quesView = new QuesView(quizController, questionsController);
        WorkQuizView workQuizView = new WorkQuizView(quizController, questionsController, quizResultController, yourAnswerController, quizView);
        MainView mainView = new MainView(quizView, workQuizView);
        LoginView loginView = new LoginView(mainView);
        loginView.menuLogin();
    }
}