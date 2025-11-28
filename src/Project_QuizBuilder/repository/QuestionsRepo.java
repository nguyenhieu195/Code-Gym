package Project_QuizBuilder.repository;

import Project_QuizBuilder.entity.Questions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionsRepo {

    private static final String FILE_PATH = "src/Project_QuizBuilder/data/questions.csv";

    private List<Questions> listQuestions;

    public QuestionsRepo() throws Exception {
        listQuestions = new ArrayList<>();
        loadFromFile();
    }

    public boolean checkQuesId(int id) {
        for (Questions q : listQuestions) {
            if (q.getId() == id) return true;
        }
        return false;
    }

    public Questions findById(int id) {
        for (Questions q : listQuestions) {
            if (q.getId() == id) return q;
        }
        return null;
    }

    public List<Questions> getListQuestions() {
        return listQuestions;
    }


    public void add(Questions ques) {
        if (!checkQuesId(ques.getId())) {
            listQuestions.add(ques);
            try {
                saveToFile();
            } catch (Exception e) {
                System.out.println("Lỗi lưu file Questions: " + e.getMessage());
            }
        }
    }

    public void removeById(int id) {
        listQuestions.removeIf(q -> Objects.equals(q.getId(), id));
        try {
            saveToFile();
        } catch (Exception e) {
            System.out.println("Lỗi lưu file Questions: " + e.getMessage());
        }
    }

    public boolean update(Questions ques) {
        for (Questions q : listQuestions) {
            if (q.getId() == ques.getId()) {
                q.setContent(ques.getContent());
                q.setAnswer(ques.getAnswer());
                q.setCorrectIndex(ques.getCorrectIndex());
                q.setScore(ques.getScore());

                try {
                    saveToFile();
                } catch (Exception e) {
                    System.out.println("Lỗi lưu file Questions: " + e.getMessage());
                }

                return true;
            }
        }
        return false;
    }

    private void loadFromFile() throws Exception {

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
                bw.write("id,quizId,content,answers,correctIndex,score");
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
                if (data.length < 6) continue;

                try {
                    int id = Integer.parseInt(data[0].trim());
                    int quizId = Integer.parseInt(data[1].trim());
                    String content = data[2].trim();

                    // answers lưu dạng A|B|C|D
                    String[] answers = data[3].split("\\|");

                    int correctIndex = Integer.parseInt(data[4].trim());
                    float score = Float.parseFloat(data[5].trim());

                    Questions q = new Questions(id, quizId, content, answers, correctIndex, score);

                    listQuestions.add(q);

                    if (id > maxId) maxId = id;

                } catch (Exception ignored) {}
            }

            // cập nhật nextID
            if (maxId > 0) {
                Questions temp = new Questions(maxId, 0, "", new String[]{}, 0, 0f);
                temp.setId(maxId);
            }

        } catch (IOException e) {
            throw new Exception("Lỗi đọc file Questions");
        }
    }


    private void saveToFile() throws Exception {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {

            bw.write("id,quizId,content,answers,correctIndex,score");
            bw.newLine();

            for (Questions q : listQuestions) {

                // ghi answers dạng A|B|C|D
                String answers = String.join("|", q.getAnswer());

                bw.write(q.getId() + "," +
                        q.getQuizId() + "," +
                        q.getContent() + "," +
                        answers + "," +
                        q.getCorrectIndex() + "," +
                        q.getScore());

                bw.newLine();
            }

        } catch (IOException e) {
            throw new Exception("Lỗi ghi file Questions");
        }
    }
}