package Project_QuizBuilder.view;

import Project_QuizBuilder.common.CheckInput;
import Project_QuizBuilder.controller.QuestionsController;
import Project_QuizBuilder.controller.QuizController;

import java.util.Scanner;

public class MainView {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PINK = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";
    public static final String BOLD = "\u001B[1m";

    private CheckInput input;
    private QuizView quizView;

    private WorkQuizView workQuiz;

    public MainView(QuizView quizView, WorkQuizView workQuiz) {
        this.quizView = quizView;
        this.workQuiz = workQuiz;
        this.input = new CheckInput();
    }


    public void menu(String username) {

        while (true) {

            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║" + BLUE + "                  MAIN MENU                   " + RESET + "║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║ 1. Management Quiz                           ║");
            System.out.println("║ 2. Work Quiz                                 ║");
            System.out.println("║ 0. Exit                                      ║");
            System.out.println("╚══════════════════════════════════════════════╝");

            int choice = input.inputInt(GREEN + "Enter choice: " + RESET);

            switch (choice) {
                case 1 -> quizView.menuQuiz();
                case 2 -> workQuiz.menu(username);
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice!" + RESET);
            }

        }
    }

}
