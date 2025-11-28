package mvc.view;

import mvc.common.CheckInput;
import mvc.controller.StudentController;
import mvc.entity.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StudentView {
    private StudentController studentController = new StudentController();

    public void view() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xóa");
            System.out.println("4. Sửa");
            System.out.println("5. Tìm kiếm");
            System.out.println("0. Quay lại");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    List<Student> students = studentController.findAll();
                    displayStudent(students);
                    break;
                case 2:
                    Integer id = inputStudentId();
                    Student student = inputStudent();
                    student.setId(id);
                    boolean isAdded = studentController.add(student);
                    if (isAdded) {
                        System.out.println("Thêm mới thành công");
                    } else {
                        System.out.println("Thêm mới thất bị, vì id trùng");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    return;
            }
        }
    }

    public void displayStudent(List<Student> students) {
        System.out.printf("%-5s %-20s %-12s %-6s%n", "ID", "Name", "DOB", "Score");
        System.out.println("------------------------------------------------------");
        for (Student student : students) {
            System.out.println(studentToString(student));
        }
    }

    public String studentToString(Student s) {
        return String.format(
                "%-5d %-20s %-12s %-6.2f",
                s.getId(),
                s.getName(),
                s.getDob().toString(),
                s.getScore()
        );
    }

    public Student inputStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        LocalDate dob = CheckInput.getDate();
        System.out.print("Nhập điểm: ");
        Float point = Float.parseFloat(scanner.nextLine());
        return new Student(null, name, dob, point);
    }



    public Integer inputStudentId() {
        Scanner scanner = new Scanner(System.in);
        Integer studentId;
        while (true) {
            try {
                System.out.print("Nhập ID: ");
                studentId = Integer.valueOf(scanner.nextLine());
                if (studentId < 0) {
                    System.out.println("ID phải là số dương");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id phải là số nguyên");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        }
        return studentId;
    }
}
