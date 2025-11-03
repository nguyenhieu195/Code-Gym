package MVC.view;

import MVC.common.CheckInput;
import MVC.controller.StudentController;
import MVC.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentView {
    StudentController studentController;

    public StudentView(StudentController studentController) {
        this.studentController = studentController;
    }

    public void menu() {
        while (true) {
            System.out.println("===== QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xoá sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Hiển thị tất cả sinh viên");
            System.out.println("5. Tìm sinh viên theo id");
            System.out.println("0. Thoát");
            int choice = CheckInput.inputInt("Chọn chức năng: ");

            switch (choice) {
                case 1:
                    addStudentView();
                    break;
                case 2:
                    removeStudentView();
                    break;
                case 3:
                    updateStudentView();
                    break;
                case 4:
                    displayAllStudentView();
                    break;
                case 5:
                    findByIdStudentView();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
            System.out.println();
        }
    }

    private void addStudentView() {
        System.out.println("---- Thêm sinh viên ----");
        int id = CheckInput.inputInt("Nhập id: ");
        String name = CheckInput.inputString("Nhập tên: ");
        LocalDate dob = CheckInput.inputDate("Nhập ngày sinh");
        float score = CheckInput.inputFloat("Nhập điểm: ");

        Student s = new Student(id, name, dob, score);
        studentController.addStudent(s);
    }

    private void removeStudentView() {
        System.out.println("---- Xoá sinh viên ----");
        int id = CheckInput.inputInt("Nhập id cần xoá: ");
        studentController.removeStudent(id);
    }

    private void updateStudentView() {
        System.out.println("---- Cập nhật sinh viên ----");
        int id = CheckInput.inputInt("Nhập id cần cập nhật: ");
        Student existing = studentController.findByIdStudent(id);
        if (existing == null) {
            System.out.println("Không tìm thấy sinh viên có id = " + id);
            return;
        }

        System.out.println("Thông tin hiện tại: " + existing);

        String name = CheckInput.inputString("Nhập tên mới (không để trống): ");
        LocalDate dob = CheckInput.inputDate("Nhập ngày sinh mới");
        float score = CheckInput.inputFloat("Nhập điểm mới: ");

        Student updated = new Student(id, name, dob, score);
        studentController.updateStudent(updated);
    }

    private void displayAllStudentView() {
        System.out.println("---- Danh sách sinh viên ----");
        ArrayList<Student> list = studentController.displayAllStudent();
        if (list.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (Student s : list) {
            System.out.println(s);
        }
    }

    private void findByIdStudentView() {
        System.out.println("---- Tìm sinh viên theo id ----");
        int id = CheckInput.inputInt("Nhập id cần tìm: ");
        Student s = studentController.findByIdStudent(id);
        if (s == null) {
            System.out.println("Không tìm thấy sinh viên có id = " + id);
        } else {
            System.out.println("Kết quả: " + s);
        }
    }
}
