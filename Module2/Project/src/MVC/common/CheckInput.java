
package MVC.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CheckInput {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DOB_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static int inputInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    public static float inputFloat(String message) {
        while (true) {
            try {
                System.out.print(message);
                String line = scanner.nextLine().trim();
                return Float.parseFloat(line);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            }
        }
    }

    public static String inputString(String message) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("Không được để trống.");
        }
    }

    public static LocalDate inputDate(String message) {
        while (true) {
            try {
                System.out.print(message + " (định dạng dd/MM/yyyy): ");
                String line = scanner.nextLine().trim();
                return LocalDate.parse(line, DOB_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ, vui lòng nhập lại.");
            }
        }
    }
}