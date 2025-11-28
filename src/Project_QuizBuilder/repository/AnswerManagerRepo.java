package Project_QuizBuilder.repository;

import Project_QuizBuilder.entity.YourAnswer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnswerManagerRepo {

    private static final String FILE_PATH = "src/Project_QuizBuilder/data/answer.csv";

    private List<YourAnswer> listAnswer;

    public AnswerManagerRepo() throws Exception {
        listAnswer = new ArrayList<>();
        loadFromFile();
    }

    public List<YourAnswer> getListAnswer() {
        return listAnswer;
    }


    public void add(YourAnswer answer) {
        listAnswer.add(answer);
        try {
            saveToFile();
        } catch (Exception e) {
            System.out.println("Lỗi lưu file Answer: " + e.getMessage());
        }
    }

    public void delete(String user) {
        listAnswer.removeIf(answer -> answer.getUsername().equals(user));
        try {
            saveToFile();
        } catch (Exception e) {
            System.out.println("Lỗi lưu file Answer: " + e.getMessage());
        }
    }

    public YourAnswer findByUsername(String username) {
        for (YourAnswer answer : listAnswer) {
            if (Objects.equals(answer.getUsername(), username)) {
                return answer;
            }
        }
        return null;
    }

    public YourAnswer findByID(int id) {
        for (YourAnswer answer : listAnswer) {
            if (answer.getId() == id) {
                return answer;
            }
        }
        return null;
    }

private void loadFromFile() throws Exception {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            // tạo file mới
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
                bw.write("id,username,quizId,resultId,userChoice");
                bw.newLine();
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            boolean isFirst = true;
            int maxId = 0;   // ⭐ THÊM

            while ((line = br.readLine()) != null) {

                if (isFirst) {
                    isFirst = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 5) continue;

                try {
                    int id = Integer.parseInt(data[0].trim());
                    String username = data[1].trim();
                    int quizId = Integer.parseInt(data[2].trim());
                    int resultId = Integer.parseInt(data[3].trim());
                    int choice = Integer.parseInt(data[4].trim());

                    YourAnswer answer = new YourAnswer(username, null, null);
                    answer.setId(id);
                    listAnswer.add(answer);

                    if (id > maxId) maxId = id;    // ⭐ THÊM

                } catch (Exception ignored) { }
            }

            if (maxId > 0 && !listAnswer.isEmpty()) {
                YourAnswer.setNextID(maxId);
            }

        } catch (IOException e) {
            throw new Exception("Lỗi đọc file YourAnswer");
        }
    }

    private void saveToFile() throws Exception {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {

            bw.write("id,username,quizId,resultId,userChoice");
            bw.newLine();

            for (YourAnswer ans : listAnswer) {

                int quizId = ans.getQuiz() != null ? ans.getQuiz().getId() : -1;
                int resultId = ans.getQuizResult() != null ? ans.getQuizResult().getId() : -1;

                // nếu bạn có userChoice thì sửa lại, tạm để -1
                int userChoice = -1;

                bw.write(ans.getId() + "," +
                        ans.getUsername() + "," +
                        quizId + "," +
                        resultId + "," +
                        userChoice);
                bw.newLine();
            }

        } catch (IOException e) {
            throw new Exception("Lỗi ghi file YourAnswer");
        }
    }

    public YourAnswer findByUserAndQuiz(String username, int quizId) {
        for (YourAnswer ans : listAnswer) {
            if (ans.getUsername().equals(username) &&
                    ans.getQuiz().getId() == quizId) {
                return ans;
            }
        }
        return null;
    }
}