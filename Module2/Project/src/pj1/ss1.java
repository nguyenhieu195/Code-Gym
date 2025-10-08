// đổi tiền
package pj1;

import java.util.Scanner;

public class ss1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn muốn đổi loại tiền nào: \n1: VND -> USD \n2: USD -> VND");
        int luachon = sc.nextInt();

        if (luachon == 1) {
            System.out.print("Nhập số tiền muốn chuyển đổi của bạn (VND): ");
            double tien = sc.nextDouble();

            final int USD = 23000;

            if (tien > 0) {
                System.out.println("Tiền của bạn sau khi chuyển sang USD = " + (tien / USD));
            } else if (tien == 0) {
                System.out.println("Số tiền chuyển đổi phải lớn hơn 0");
            } else {
                System.out.println("Số tiền không hợp lệ");
            }
        }else  if (luachon == 2) {
            System.out.print("Nhập số tiền muốn chuyển đổi của bạn (USD): ");
            double tien = sc.nextDouble();

            final int USD = 23000;

            if (tien > 0) {
                System.out.println("Tiền của bạn sau khi chuyển sang VND = " + (tien * USD));
            } else if (tien == 0) {
                System.out.println("Số tiền chuyển đổi phải lớn hơn 0");
            } else {
                System.out.println("Số tiền không hợp lệ");
            }
        }
        else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }
}
//hahaa