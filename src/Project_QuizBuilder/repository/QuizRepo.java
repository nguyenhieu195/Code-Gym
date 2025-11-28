package Project_QuizBuilder.repository;

import Project_QuizBuilder.entity.Quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuizRepo {

    private static final String FILE_PATH = "src/Project_QuizBuilder/data/quiz.csv";

    private List<Quiz> quizLists;

    public QuizRepo() throws Exception {
        quizLists = new ArrayList<>();
        loadFromFile();
    }

    public List<Quiz> getQuizLists() {
        return quizLists;
    }

    public boolean checkQuizId(int id) {
        for (Quiz quiz : quizLists) {
            if (quiz.getId() == id) return true;
        }
        return false;
    }

    public Quiz findById(int id) {
        for (Quiz q : quizLists) {
            if (q.getId() == id) return q;
        }
        return null;
    }

    public void add(Quiz quiz) {
        if (!checkQuizId(quiz.getId())) {
            quizLists.add(quiz);
            try {
                saveToFile();
            } catch (Exception e) {
                System.out.println("Lỗi lưu file Quiz: " + e.getMessage());
            }
        }
    }


    public void removeById(int id) {
        quizLists.removeIf(quiz -> Objects.equals(quiz.getId(), id));
        try {
            saveToFile();
        } catch (Exception e) {
            System.out.println("Lỗi lưu file Quiz: " + e.getMessage());
        }
    }

    public boolean updateQuiz(Quiz quiz) {
        for (Quiz q : quizLists) {
            if (q.getId() == quiz.getId()) {
                q.setTitle(quiz.getTitle());

                try {
                    saveToFile();
                } catch (Exception e) {
                    System.out.println("Lỗi lưu file Quiz: " + e.getMessage());
                }

                return true;
            }
        }
        return false;
    }

    private void loadFromFile() throws Exception {

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            // tạo file mới
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
                bw.write("id,title");
                bw.newLine();
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            boolean isFirst = true;
            int maxId = 0;

            while ((line = br.readLine()) != null) {

                if (isFirst) {
                    isFirst = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 2) continue;

                try {
                    int id = Integer.parseInt(data[0].trim());
                    String title = data[1].trim();

                    Quiz quiz = new Quiz(id, title);
                    quizLists.add(quiz);

                    if (id > maxId) maxId = id;

                } catch (Exception ignored) {}
            }

            // cập nhật nextID
            if (maxId > 0) {
                Quiz.setNextID(maxId);
            }

        } catch (IOException e) {
            throw new Exception("Lỗi đọc file Quiz");
        }
    }

    private void saveToFile() throws Exception {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {

            bw.write("id,title");
            bw.newLine();

            for (Quiz q : quizLists) {
                bw.write(q.getId() + "," + q.getTitle());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new Exception("Lỗi ghi file Quiz");
        }
    }
}