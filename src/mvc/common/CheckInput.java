package mvc.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CheckInput {

    public static LocalDate getDate() {
        Scanner scanner = new Scanner(System.in);
        LocalDate dob;
        String date;
        while (true) {
            try {
                System.out.print("Nhập ngày: ");
                date = scanner.nextLine();
                dob = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Vui lòng nhập đúng định dạng yyyy-MM-dd");
            }
        }
        return dob;
    }
}
