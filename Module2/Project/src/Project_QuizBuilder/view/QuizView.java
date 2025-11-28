package Project_QuizBuilder.view;

import Project_QuizBuilder.common.CheckInput;
import Project_QuizBuilder.common.TryCatch;
import Project_QuizBuilder.entity.Quiz;
import Project_QuizBuilder.controller.QuestionsController;
import Project_QuizBuilder.controller.QuizController;

import java.sql.SQLOutput;

public class QuizView {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PINK = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";

    private CheckInput input;
    private QuizController controllerQuizs;
    private QuestionsController controllerQuestions;

    public QuizView(QuizController quizs, QuestionsController questions) {
        this.controllerQuizs = quizs;
        this.controllerQuestions = questions;
        this.input = new CheckInput();
    }


    public void menuQuiz() {
        while (true) {

            displayQuiz();

            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║" + BLUE + "                  QUIZ MENU                   " + RESET + "║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  1. Add new Quiz                             ║");
            System.out.println("║  2. Delete Quiz                              ║");
            System.out.println("║  3. Find Quiz                                ║");
            System.out.println("║  4. Update Quiz                              ║");
            System.out.println("║  5. Display Quiz                             ║");
            System.out.println("║  0. Exit                                     ║");
            System.out.println("╚══════════════════════════════════════════════╝");

            int choice = input.inputInt(GREEN + "Enter choice: " + RESET);

            switch (choice) {
                case 1 -> addQuiz();
                case 2 -> removeQuiz();
                case 3 -> findQuiz();
                case 4 -> updateQuiz();
                case 5 -> displayQuiz();
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice!" + RESET);
            }
        }
    }

    public void displayQuiz() {

        System.out.println("╔═════╦════════════════════════════════════════╗");
        System.out.printf("║ %-3s ║ %-34s     ║%n", "ID", "Title");
        System.out.println("╠═════╬════════════════════════════════════════╣");

        for (Quiz quiz : controllerQuizs.getListQuiz()) {
            System.out.printf("║ %-3d ║ %-34s     ║%n",
                    quiz.getId(),
                    quiz.getTitle());
        }

        System.out.println("╚═════╩════════════════════════════════════════╝");

    }

    public void addQuiz() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║" + BLUE + "         ADD NEW QUIZ         " + RESET + "║");
        System.out.println("╚══════════════════════════════╝");
        String title = input.inputString("Title: ");

        Quiz quiz = new Quiz(title);
        TryCatch.tryDo(() -> controllerQuizs.add(quiz));

        if (TryCatch.tryCall(() -> controllerQuizs.findById(quiz.getId())) == null) {
            System.out.println(RED + "Failed to add quiz!" + RESET);
        } else {
            System.out.println(YELLOW + "Quiz added successfully!" + RESET);
        }
    }

    public void findQuiz() {

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║" + BLUE + "          FIND QUIZ           " + RESET + "║");
        System.out.println("╚══════════════════════════════╝");
        int id = input.inputPositiveInt("Enter the Quiz ID you want to search: ");

        Quiz quiz = TryCatch.tryCall(() -> controllerQuizs.findById(id));

        if (quiz != null) {

            System.out.println("╔═════╦════════════════════════════════════════╗");
            System.out.printf("║ %-3s ║ %-34s     ║%n", "ID", "Title");
            System.out.println("╠═════╬════════════════════════════════════════╣");
            System.out.printf("║ %-3d ║ %-34s     ║%n", quiz.getId(), quiz.getTitle());
            System.out.println("╚═════╩════════════════════════════════════════╝");

            QuesView quesView = new QuesView(controllerQuizs, controllerQuestions);
            quesView.displayQuestionsByQuiz(quiz.getId());

        } else {
            System.out.println(RED + "Quiz not found!" + RESET);
        }
    }

    public void removeQuiz() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║" + BLUE + "          DELETE QUIZ         " + RESET + "║");
        System.out.println("╚══════════════════════════════╝");
        int id = input.inputPositiveInt("ID: ");

        if (TryCatch.tryCall(() -> controllerQuizs.findById(id)) != null) {
            TryCatch.tryDo(() -> controllerQuizs.remove(id));
            System.out.println(YELLOW + "Removed successfully!" + RESET);
            return;
        }

        System.out.println(RED + "Quiz not found!" + RESET);
    }

    public void updateQuiz() {

        while (true) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║" + BLUE + "          UP QUIZ             " + RESET + "║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Update quiz title         ║");
            System.out.println("║ 2. Update questions          ║");
            System.out.println("║ 0. Cancel                    ║");
            System.out.println("╚══════════════════════════════╝");

            int choice = input.inputInt(GREEN + "Enter your selection: " + RESET);

            switch (choice) {
                case 1:
                    int id = input.inputPositiveInt("Enter Quiz ID: ");
                    Quiz quiz = TryCatch.tryCall(() -> controllerQuizs.findById(id));

                    if (quiz != null) {
                        String title = input.inputString("New Title: ");
                        Quiz newQuiz = new Quiz(id, title);
                        TryCatch.tryDo(() -> controllerQuizs.update(newQuiz));
                        System.out.println(YELLOW + "Update successful!" + RESET);
                    } else {
                        System.out.println(RED + "Quiz not found!" + RESET);
                    }
                    break;

                case 2:
                    QuesView quesView = new QuesView(controllerQuizs, controllerQuestions);
                    quesView.menuQuess();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(RED + "Invalid choice!" + RESET);
            }
        }
    }
}
