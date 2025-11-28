package Project_QuizBuilder.view;

import Project_QuizBuilder.common.CheckInput;
import Project_QuizBuilder.common.TryCatch;
import Project_QuizBuilder.entity.Questions;
import Project_QuizBuilder.entity.Quiz;
import Project_QuizBuilder.controller.QuestionsController;
import Project_QuizBuilder.controller.QuizController;


public class QuesView {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    private CheckInput input;
    private QuestionsController questions;
    private QuizController quizs;

    public QuesView(QuizController quizRepo, QuestionsController quesRepo) {
        this.quizs = quizRepo;
        this.questions = quesRepo;
        this.input = new CheckInput();
    }

    public void menuQuess() {
        while (true) {
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║" + BLUE + "             QUESTION MANAGEMENT              " + RESET + "║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║ 1. Add Question                              ║");
            System.out.println("║ 2. Update Question                           ║");
            System.out.println("║ 3. Delete Question                           ║");
            System.out.println("║ 4. Find Question by ID                       ║");
            System.out.println("║ 5. Find Question by Quiz                     ║");
            System.out.println("║ 6. Display All Questions                     ║");
            System.out.println("║ 0. Exit                                      ║");
            System.out.println("╚══════════════════════════════════════════════╝");

            int choice = input.inputInt(GREEN + "Enter choice: " + RESET);

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    findById();
                    break;
                case 5:
                    int id = input.inputInt("Enter Quiz ID: ");
                    displayQuestionsByQuiz(id);
                    break;
                case 6:
                    displayAll();
                    break;
                case 0:
                    return;
                default:
                    System.out.println(RED + "Invalid choice!" + RESET);
            }
        }
    }

    public void displayAll() {

        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║" + BLUE + "                                             ALL QUESTIONS                                               " + RESET + "║");
        System.out.println("╠══════════════════════╦══════════╦══════════════════════════════════════════════╦════════════════════════╣");
        System.out.printf("║ %-20s ║ %-8s ║ %-44s ║ %-22s ║%n", "Quiz Title", "ID", "Question", "Answers");
        // Nội dung
        for (Questions ques : questions.getListQuestions()) {
            System.out.println("╠══════════════════════╬══════════╬══════════════════════════════════════════════╬════════════════════════╣");
            // Lấy Title của Quiz
            String title = "";
            for (Quiz q : quizs.getListQuiz()) {
                if (q.getId() == ques.getQuizId()) {
                    title = q.getTitle();
                    break;
                }
            }

            char option = 'A';
            String firstAns = option + ". " + ques.getAnswer()[0];

            // ---- Dòng đầu tiên (full dữ liệu) ----
            System.out.printf("║ %-20s ║ %-8s ║ %-44s ║ %-22s ║%n", title, ques.getId(), ques.getContent(), firstAns);

            option++;

            // ---- Các đáp án còn lại ----
            for (int i = 1; i < ques.getAnswer().length; i++) {

                String ans = option + ". " + ques.getAnswer()[i];

                System.out.printf("║ %-20s ║ %-8s ║ %-44s ║ %-22s ║%n", "", "", "", ans);

                option++;
            }

        }
        System.out.println("╚══════════════════════╩══════════╩══════════════════════════════════════════════╩════════════════════════╝");
    }

    public void displayQuestionsByQuiz(int id) {

        System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║" + BLUE + "                               DISPLAY QUESTIONS BY QUIZ                               " + RESET + "║");
        System.out.println("╠════════╦══════╦══════════════════════════════════════════════╦════════════════════════╣");
        System.out.printf("║ %-6s ║ %-4s ║ %-44s ║ %-22s ║%n",
                "QuizID", "ID", "Question", "Answers");

        Quiz q = TryCatch.tryCall(() -> quizs.findById(id));

        for (Questions ques : questions.getListQuestions()) {
            if (ques.getQuizId() == q.getId()) {
                System.out.println("╠════════╬══════╬══════════════════════════════════════════════╬════════════════════════╣");
                char option = 'A';
                String firstAns = option + ". " + ques.getAnswer()[0];
                // Dòng câu hỏi + đáp án đầu tiên
                System.out.printf("║ %-6d ║ %-4d ║ %-44s ║ %-22s ║%n", ques.getQuizId(), ques.getId(), ques.getContent(), firstAns);
                option++;

                // Các đáp án còn lại (SỬA ĐÚNG Ở ĐÂY)
                for (int i = 1; i < ques.getAnswer().length; i++) {
                    String ans = option + ". " + ques.getAnswer()[i];
                    // KHÔNG dùng %d nữa → dùng %s
                    System.out.printf("║ %-6s ║ %-4s ║ %-44s ║ %-22s ║%n", "", "", "", ans);
                    option++;
                }

            }
        }

        System.out.println("╚════════╩══════╩══════════════════════════════════════════════╩════════════════════════╝");
    }

    public void findById() {

        int id = input.inputInt("Enter the Question ID you want to find: ");
        Questions ques = TryCatch.tryCall(() -> questions.findById(id));

        if (ques == null) {
            System.out.println("Question not found!");
            return;
        }

        // Lấy tiêu đề quiz
        String title = "";
        for (Quiz quiz : quizs.getListQuiz()) {
            if (quiz.getId() == ques.getQuizId()) {
                title = quiz.getTitle();
                break;
            }
        }

        // HEADER bảng

        System.out.println("╔═════════════════╦═══════╦════════════════════════════════╦════════════════════════════════╦════════════╗");
        System.out.printf("║ %-15s ║ %-5s ║ %-30s ║ %-30s ║ %-10s ║%n",
                "Quiz", "ID", "Question", "Answers", "Correct");
        System.out.println("╠═════════════════╬═══════╬════════════════════════════════╬════════════════════════════════╬════════════╣");

        char op = 'A';

        // Đáp án đầu tiên
        String firstAns = op + ". " + ques.getAnswer()[0];
        String correct = (ques.getCorrectIndex() == 0) ? firstAns : "";

        System.out.printf("║ %-15s ║ %-5s ║ %-30s ║ %-30s ║ %-10s ║%n",
                title,
                ques.getId(),
                ques.getContent(),
                firstAns,
                correct);

        op++;

        // Các đáp án còn lại
        for (int i = 1; i < ques.getAnswer().length; i++) {

            String ans = op + ". " + ques.getAnswer()[i];
            String correctAns = (i == ques.getCorrectIndex()) ? ans : "";

            System.out.printf("║ %-15s ║ %-5s ║ %-30s ║ %-30s ║ %-10s ║%n",
                    "", "", "",
                    ans,
                    correctAns);

            op++;
        }
        System.out.println("╚═════════════════╩═══════╩════════════════════════════════╩════════════════════════════════╩════════════╝");


    }

    public void remove() {

        displayAll();
        int id = input.inputPositiveInt("Enter the Question ID you want to delete: ");
        Questions ques = TryCatch.tryCall(() -> questions.findById(id));

        if (ques != null) {
            TryCatch.tryDo(() -> questions.remove(id));
            System.out.println(YELLOW + "Deleted successfully!" + RESET);
            return;
        }

        System.out.println(RED + "ID not found!" + RESET);
    }

    public void add() {

        int id = input.inputPositiveInt("Enter the Quiz ID to add a question: ");
        Quiz quiz = TryCatch.tryCall(() -> quizs.findById(id));

        if (quiz == null) {
            System.out.println(RED + "Quiz does not exist" + RESET);
            return;
        }

        Questions question = formInput(quiz);
        TryCatch.tryDo(() -> questions.add(question));
        System.out.println(YELLOW + "Question added successfully!" + RESET);
    }

    public void update() {

        displayAll();
        int id = input.inputPositiveInt("Enter the Question ID you want to update: ");
        Questions ques = TryCatch.tryCall(() -> questions.findById(id));

        if (ques == null) {
            System.out.println(RED + "Question ID does not exist!" + RESET);
            return;
        }

        // Lấy quiz hiện tại của câu hỏi
        Quiz quiz = TryCatch.tryCall(() -> quizs.findById(ques.getQuizId()));

        // Nhập dữ liệu mới (nội dung, đáp án, score, correctIndex,...)
        Questions newQues = formInput(quiz);

        // Tạo bản updated, GIỮ ID cũ, chỉ thay nội dung
        Questions updated = new Questions(
                ques.getId(),          // giữ ID cũ
                ques.getQuizId(),      // giữ QuizID cũ
                newQues.getContent(),
                newQues.getAnswer(),
                newQues.getCorrectIndex(),
                newQues.getScore()
        );

        boolean ok = TryCatch.tryDo(() -> questions.update(updated));

        if (ok) {
            System.out.println(YELLOW + "Update successful!" + RESET);
        } else {
            System.out.println(RED + "Failed to update the question!" + RESET);
        }

    }

    private Questions formInput(Quiz quiz) {

        String content = input.inputString("Enter the question content: ");
        int n = input.inputPositiveInt("Enter the number of answers: ");

        String[] answers = new String[n];
        char option = 'A';
        for (int i = 0; i < n; i++) {
            answers[i] = input.inputString("Enter answer " + option++ + ": ");
        }

        char correct = input.inputChar("Enter the correct answer (a,b,...): ");

        int correctIndex = -1;
        char checkAns = 'A';
        for (int i = 0; i < answers.length; i++) {
            if (checkAns == correct) {
                correctIndex = i;
                break;
            }
            checkAns++;
        }

        float score = input.inputPositiveInt("Enter the score: ");

        if (correctIndex == -1) {
            System.out.println("Invalid correct answer!");
            return null;
        }

// use ADD constructor → auto-increment ID
        return new Questions(
                quiz.getId(),
                content,
                answers,
                correctIndex,
                score
        );
    }
}
