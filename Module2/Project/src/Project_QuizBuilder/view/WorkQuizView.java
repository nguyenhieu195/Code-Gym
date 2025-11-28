package Project_QuizBuilder.view;

import Project_QuizBuilder.common.CheckInput;
import Project_QuizBuilder.common.TryCatch;
import Project_QuizBuilder.controller.QuestionsController;
import Project_QuizBuilder.controller.QuizController;
import Project_QuizBuilder.controller.QuizResultController;
import Project_QuizBuilder.controller.YourAnswerController;
import Project_QuizBuilder.entity.Questions;
import Project_QuizBuilder.entity.Quiz;
import Project_QuizBuilder.entity.QuizResult;
import Project_QuizBuilder.entity.YourAnswer;

import java.security.PublicKey;

public class WorkQuizView {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PINK = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";

    private QuizView viewQuiz;
    private YourAnswerController yourAnswerController;
    private QuizController quizController;
    private QuestionsController questionsController;
    private QuizResultController quizResultController;
    private CheckInput input;

    public WorkQuizView(QuizController quizController, QuestionsController questionsController, QuizResultController quizResultController, YourAnswerController yourAnswerController, QuizView quizView) {

        this.quizController = quizController;
        this.questionsController = questionsController;
        this.yourAnswerController = yourAnswerController;
        this.quizResultController = quizResultController;
        this.viewQuiz = quizView;
        this.input = new CheckInput();
    }

    public void menu() {
        while (true) {
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║" + BLUE + "                  WORK QUIZ                   " + RESET + "║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║ 1. Work Quiz                                 ║");
            System.out.println("║ 2. Answer                                    ║");
            System.out.println("║ 0. Exit                                      ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            int choice = input.inputInt("Enter choice: ");
            switch (choice) {
                case 1 -> workQuiz();
                case 2 -> Answer();
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice!" + RESET);
            }
        }
    }

    public void workQuiz() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║" + BLUE + "          WORK QUIZ           " + RESET + "║");
        System.out.println("╚══════════════════════════════╝");
        String username = input.inputString("Enter Username: ");
        int correctCount = 0;
        float score = 0;
        String usernameRegex = "^[a-z]{5,12}[0-9]{3,8}$";

        while (!username.matches(usernameRegex)) {
            System.out.println("Invalid username!");
            username = input.inputString("Enter Username: ");
        }

        if (quizResultController.findByUsername(username) != null) {
            System.out.println("User name has existed !");
            return;
        }

        viewQuiz.displayQuiz();
        int id = input.inputInt("ENTER CHOICE ID: ");

        Quiz quiz = TryCatch.tryCall(() -> quizController.findById(id));

        for (Questions ques : questionsController.getListQuestions()) {

            if (ques.getQuizId() == quiz.getId()) {
                System.out.println("╔════════════╦════════════╦══════════════════════════════════════════╦══════════════════════════════╗");
                System.out.printf("║ %-10s ║ %-10s ║ %-40s ║ %-28s ║%n", "QuizID", "ID", "Question", "Answers");
                System.out.println("╠════════════╬════════════╬══════════════════════════════════════════╬══════════════════════════════╣");
                char option = 'A';
                String firstAns = option + ". " + ques.getAnswer()[0];

                // dòng đầu tiên
                System.out.printf("║ %-10d ║ %-10d ║ %-40s ║ %-28s ║%n",
                        ques.getQuizId(),
                        ques.getId(),
                        ques.getContent(),
                        firstAns);

                option++;

                // các đáp án còn lại
                for (int i = 1; i < ques.getAnswer().length; i++) {
                    String ans = option + ". " + ques.getAnswer()[i];

                    System.out.printf("║ %-10s ║ %-10s ║ %-40s ║ %-28s ║%n",
                            "", "", "", ans);
                    option++;
                }
                System.out.println("╚════════════╩════════════╩══════════════════════════════════════════╩══════════════════════════════╝");

                boolean check = false;
                char answer = input.inputChar("Enter your answer (A,B,..): ");
                char checkAns = 'A';

                for (int i = 0; i < ques.getAnswer().length; i++) {
                    if (i == ques.getCorrectIndex()) {
                        if (answer == checkAns) {
                            score += ques.getScore();
                            correctCount++;
                            check = true;
                            break;
                        }
                    }
                    checkAns++;
                }

                if (!check) {
                    System.out.println(RED + "Wrong answer!" + RESET);
                    if (answer < 'A' || answer >= checkAns) {
                        System.out.println(RED + "Invalid answer!" + RESET);
                    }
                } else {
                    System.out.println(YELLOW + "Correct!" + RESET);
                }
            }
        }

        QuizResult quizResult = new QuizResult(username, quiz, correctCount, score);
        quizResultController.save(quizResult);
        YourAnswer answer = new YourAnswer(username, quiz, quizResult);
        yourAnswerController.add(answer);
    }

    public void displayAnswer() {

        System.out.println("╔══════════╦════════════════════════════════╗");
        System.out.printf ("║ %-8s ║ %-30s ║%n", "ID", "USERNAME");
        System.out.println("╠══════════╬════════════════════════════════╣");

        for (YourAnswer yourAnswer : yourAnswerController.getListAnswer()) {
            System.out.printf("║ %-8d ║ %-30s ║%n",
                    yourAnswer.getId(),
                    yourAnswer.getUsername());
        }

        System.out.println("╚══════════╩════════════════════════════════╝");
    }

    public void Answer() {
        while (true) {
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║" + BLUE + "                    ANSWER                    " + RESET + "║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║ 1. View Score                                ║");
            System.out.println("║ 2. View All Score                            ║");
            System.out.println("║ 3. Edit Answer                               ║");
            System.out.println("║ 0. Exit                                      ║");
            System.out.println("╚══════════════════════════════════════════════╝");

            int choice = input.inputInt(GREEN + "Enter choice: " + RESET);

            switch (choice) {
                case 1 -> viewScore();
                case 2 -> viewALLScore();
                case 3 -> editAnswer();
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice!" + RESET);
            }
        }
    }

    public void viewScore() {

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║" + BLUE + "          VIEW SCORE          " + RESET + "║");
        System.out.println("╚══════════════════════════════╝");
        displayAnswer();
        String username = input.inputString("Enter Username: ");

        YourAnswer answers = TryCatch.tryCall(() -> yourAnswerController.findByUsername(username));
        if (answers == null) {
            System.out.println(RED + "Invalid username!" + RESET);
            return;
        }
        for (YourAnswer ans : yourAnswerController.getListAnswer()) {
            if (ans.getUsername().equals(username)) {
                System.out.println("╔══════════════════════════════╦══════════════════════════════╗");
                System.out.printf("║ %-28s ║ %-28s ║%n", "Username", username);
                System.out.printf("║ %-28s ║ %-28s ║%n", "Quiz", ans.getQuiz().getTitle());
                System.out.printf("║ %-28s ║ %-28s ║%n", "Number of correct sentences", ans.getQuizResult().getCorrectCount());
                System.out.printf("║ %-28s ║ %-28s ║%n", "Score", ans.getQuizResult().getSumScore());
                System.out.println("╚══════════════════════════════╩══════════════════════════════╝");
                break;
            }
        }
    }

    public void viewALLScore() {

        System.out.println("╔═════════════════════════════════════════════════════════════╗");
        System.out.println("║" + BLUE + "                       VIEW ALL SCORES                       " + RESET + "║");
        System.out.println("╠══════════════════════════════╦══════════════════════════════╣");

        for (YourAnswer ans : yourAnswerController.getListAnswer()) {
            System.out.printf("║ %-28s ║ %-28s ║%n", "Username", ans.getUsername());
            System.out.printf("║ %-28s ║ %-28s ║%n", "Quiz", ans.getQuiz().getTitle());
            System.out.printf("║ %-28s ║ %-28s ║%n", "Number of correct sentences", ans.getQuizResult().getCorrectCount());
            System.out.printf("║ %-28s ║ %-28s ║%n", "Score", ans.getQuizResult().getSumScore());
            System.out.println("╠══════════════════════════════╬══════════════════════════════╣");
        }
        System.out.println("╚══════════════════════════════╩══════════════════════════════╝");

    }

    public void editAnswer() {
        while (true) {
            displayAnswer();
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║" + BLUE + "         EDIT ANSWER          " + RESET + "║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Delete Answer             ║");
            System.out.println("║ 2. Find Answer               ║");
            System.out.println("║ 0. Exit                      ║");
            System.out.println("╚══════════════════════════════╝");
            int choice = input.inputInt(GREEN + "Enter choice: " + RESET);
            switch (choice) {
                case 1 -> deleteAns();
                case 2 -> findAns();
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice!" + RESET);
            }
        }
    }

    public void deleteAns() {
        displayAnswer();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║" + BLUE + "        DELETE ANSWER         " + RESET + "║");
        System.out.println("╚══════════════════════════════╝");
        String username = input.inputString("Enter Username: ");

        YourAnswer answers = TryCatch.tryCall(() -> yourAnswerController.findByUsername(username));
        if (answers == null) {
            System.out.println(RED + "Invalid username!" + RESET);
            return;
        }

        for (YourAnswer ans : yourAnswerController.getListAnswer()) {
            if (ans.getUsername().equals(username)) {
                yourAnswerController.delete(ans.getUsername());
                System.out.println(YELLOW + "Delete answer successfully!" + RESET);
                return;
            }
        }
    }

    public void findAns() {
        displayAnswer();
        String username = input.inputString("Enter Username: ");
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║" + BLUE + "         FIND ANSWER          " + RESET + "║");
        System.out.println("╚══════════════════════════════╝");
        YourAnswer answers = TryCatch.tryCall(() -> yourAnswerController.findByUsername(username));
        if (answers == null) {
            System.out.println(RED + "Invalid username!" + RESET);
            return;
        }

        for (YourAnswer ans : yourAnswerController.getListAnswer()) {
            if (ans.getUsername().equals(username)) {
                System.out.println("╔══════════════════════════════╦══════════════════════════════╗");
                System.out.printf("║ %-28s ║ %-28s ║%n", "Username", ans.getUsername());
                System.out.printf("║ %-28s ║ %-28s ║%n", "Quiz", ans.getQuiz().getTitle());
                System.out.printf("║ %-28s ║ %-28s ║%n", "Number of correct sentences", ans.getQuizResult().getCorrectCount());
                System.out.printf("║ %-28s ║ %-28s ║%n", "Score", ans.getQuizResult().getSumScore());
                break;
            }
        }

        System.out.println("╚══════════════════════════════╩══════════════════════════════╝");
    }


}
