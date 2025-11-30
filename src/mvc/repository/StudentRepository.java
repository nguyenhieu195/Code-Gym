package mvc.repository;

import mvc.entity.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentRepository {


    public List<Student> findAll() {
        File file = new File("mvc/data/student.csv");
        List<Student> students = new ArrayList<>();
//        try with resources (Java 8)
        try ( FileReader fileReader = new FileReader(file);
              BufferedReader br = new BufferedReader(fileReader)) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    students.add(new Student(Integer.parseInt(data[0]), data[1], LocalDate.parse(data[2], DateTimeFormatter.ofPattern("yyyy-MM-dd")), Float.parseFloat(data[3])));
                }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }

        return students;
    }

    public void save(Student student) {
        File file = new File("mvc/data/student.csv");
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(convertStudentToString(student));
            bufferedWriter.newLine();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertStudentToString(Student student) {
        return student.getId()+","+student.getName()+","+student.getDob().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+","+student.getScore();
    }
}
