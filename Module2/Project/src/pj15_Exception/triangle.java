package pj15_Exception;

import java.util.Scanner;

class IllegalTriangleException extends Exception{
    public IllegalTriangleException(String mess){
        super(mess);
    }

}
public class triangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;

        while (true){
            try {
                System.out.println("Nhập 3 cạnh của tam giác: ");
                System.out.println("Nhập cạnh a");
                a = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập cạnh b");
                b = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập cạnh c");
                c = Integer.parseInt(scanner.nextLine());

                if(a <= 0 || b <= 0 || c <= 0){
                    throw new IllegalTriangleException("Cạnh phải lớn hơn 0 !");
                }
                if (a + b <= c || b + c <= a || c + a <= b){
                    throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại !");
                }
                System.out.println("3 canh cua hinh tam giac: " + a + " " + b + " " + c);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập s hợp lệ !");
            } catch (IllegalTriangleException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
