package IntroductionToJava;
import java.util.Scanner;
public class DisplayByYourName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap tên của bạn: ");
        String ten = sc.nextLine();

        System.out.println("Helo " + ten);
    }
}
