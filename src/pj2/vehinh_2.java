package pj2;

public class vehinh_2 {
    public static void main(String[] args) {
        System.out.println("In hình chữ nhật cao=3 và rộng=10");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Tam giác vuông, góc vuông ở dưới-trái ");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("Tam giác vuông, góc vuông ở trên-trái");
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
