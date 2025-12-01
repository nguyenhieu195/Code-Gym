package HeThongQuanLySinhVien.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CheckInput {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";


    private Scanner scanner = new Scanner(System.in);
    public LocalDate getDate(String mess) {
        LocalDate dob;
        String date;
        while (true) {
            try {
                System.out.print(mess);
                date = scanner.nextLine();
                dob = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Vui lòng nhập đúng định dạng dd/MM/yyyy");
            }
        }
        return dob;
    }
    public int inputInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(RED + "Please enter a valid integer !" + RESET);
            }
        }
    }

    public float inputFloat(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Float.parseFloat(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(RED + "Please enter a valid float !" + RESET);
            }
        }
    }

    // số nguyên lớn hơn 0, dùng khi nhập số đáp án,.....
    public int inputPositiveInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                int num = Integer.parseInt(scanner.nextLine().trim());
                if (num > 0) return num;
                System.out.println(RED + "Number must be greater than 0!" + RESET);
            } catch (NumberFormatException e) {
                System.out.println(RED + "Please enter a valid integer !" + RESET);
            }
        }
    }

    public float inputPositiveFloat(String message) {

        while (true) {
            try {
                System.out.print(message);
                float num = Float.parseFloat(scanner.nextLine().trim());
                if (num > 0) return num;
                System.out.println(RED + "Number must be greater than 0!" + RESET);
            } catch (NumberFormatException e) {
                System.out.println(RED + "Please enter a valid float !" + RESET);
            }
        }
    }

    // chuỗi không null
    public String inputString(String message) {

        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim();
            if (!text.isEmpty()) return text;
            System.out.println(RED + "NOT NULL !" + RESET);
        }
    }

    public char inputChar(String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim().toUpperCase();

            if (text.length() == 1) {
                return text.charAt(0); // trả về ký tự
            }

            System.out.println(RED + "Please enter exactly ONE character!" + RESET);
        }
    }
}

