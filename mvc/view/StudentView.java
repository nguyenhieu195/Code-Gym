package mvc.view;

import mvc.controller.StudentController;
import mvc.entity.Student;

import java.util.List;
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
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
