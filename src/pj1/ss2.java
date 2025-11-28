//hiển thị tên
package pj1;

import java.util.Scanner;

public class ss2 {
    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Nhap tên của bạn: ");
//        String ten = sc.nextLine();
//
//        System.out.println("Helo " + ten);
//    }

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PINK = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static void main(String[] args) {
        System.out.println(GREEN+ "Đây là chữ màu đỏ" );
        System.out.println(GREEN + "Đây là chữ màu xanh lá" + RESET);
        System.out.println(BLUE + "Đây là chữ màu xanh dương" + RESET);
        System.out.println(CYAN + "Đây là chữ màu cyan" + RESET);
    }
}
