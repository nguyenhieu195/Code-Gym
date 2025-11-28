package pj19_StringAndRegex;

import java.util.Scanner;

public class ValidateSDT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexSTD = "^(0)[0-9]{9}$";
        System.out.print("Nhập số điện thoại: ");
        String SDT = scanner.nextLine();
        while (!SDT.matches(regexSTD)) {
            System.out.println("Số điện thoại chưa hợp lệ !");
            System.out.print("Nhập lại: ");
            SDT = scanner.nextLine();
        }
        System.out.println("DONE !");
    }
}
