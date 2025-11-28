package Project_QuizBuilder.repository;

import Project_QuizBuilder.entity.Quiz;
import Project_QuizBuilder.entity.QuizResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuizResultRepo {

    private static final String FILE_PATH = "src/Project_QuizBuilder/data/quiz_result.csv";

    private List<QuizResult> quizResults;

    public QuizResultRepo() throws Exception {
        quizResults = new ArrayList<>();
        loadFromFile();
    }

    public List<QuizResult> getQuizResults() {
        return quizResults;
    }


    public void save(QuizResult quizResult) {
        quizResults.add(quizResult);
        try {
            saveToFile();
        } catch (Exception e) {
            System.out.println("Lỗi lưu file QuizResult: " + e.getMessage());
        }
    }

    public void delete(int id){
        quizResults.removeIf(q -> q.getId() == id);
        try {
            saveToFile();
        } catch (Exception e) {
            System.out.println("Lỗi lưu file QuizResult: " + e.getMessage());
        }
    }


    public QuizResult findById(int id){
        for (QuizResult quizResult : quizResults) {
            if(quizResult.getId() == id){
                return quizResult;
            }
        }
        return null;
    }


    public QuizResult findByUsername(String name){
        for (QuizResult quizResult : quizResults) {
            if(quizResult.getUsername().equals(name)){
                return quizResult;
            }
        }
        return null;
    }

    private void loadFromFile() throws Exception {

        File file = new File(FILE_PATH);

        // nếu file chưa tồn tại -> tạo mới
        if (!file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
                bw.write("id,username,quizId,correctCount,sumScore");
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
                    continue; // bỏ header
                }

                String[] data = line.split(",");
                if (data.length < 5) continue;

                try {
                    int id = Integer.parseInt(data[0].trim());
                    String username = data[1].trim();

                    int quizId = Integer.parseInt(data[2].trim());
                    Quiz quiz = new Quiz(quizId, "");  // quiz giả

                    int correctCount = Integer.parseInt(data[3].trim());
                    float sumScore = Float.parseFloat(data[4].trim());

                    // tạo QuizResult đúng model mới
                    QuizResult qr = new QuizResult(username, quiz, correctCount, sumScore);

                    qr.setId(id); // giữ ID gốc

                    quizResults.add(qr);

                    if (id > maxId) maxId = id;

                } catch (Exception ignored) {}
            }

            // cập nhật nextID đúng
            if (maxId > 0 && !quizResults.isEmpty()) {
                quizResults.get(quizResults.size() - 1).setNextID(maxId);
            }

        } catch (IOException e) {
            throw new Exception("Lỗi đọc file QuizResult");
        }
    }


    private void saveToFile() throws Exception {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {

            bw.write("id,username,quizId,correctCount,sumScore");
            bw.newLine();

            for (QuizResult r : quizResults) {

                int quizId = 0;
                if (r.getQuiz() != null && r.getQuiz().getId() != null)
                    quizId = r.getQuiz().getId();

                bw.write(
                        r.getId() + "," +
                                r.getUsername() + "," +
                                quizId + "," +
                                r.getCorrectCount() + "," +
                                r.getSumScore()
                );

                bw.newLine();
            }

        } catch (IOException e) {
            throw new Exception("Lỗi ghi file QuizResult");
        }
    }
}