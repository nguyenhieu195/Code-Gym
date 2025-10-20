package pj6_Polymorphism.Triangle;

import java.util.Scanner;

public class Test {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle();
        System.out.println(triangle1);

        System.out.print("Nhap canh 1: ");
        double a = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap canh 2: ");
        double b = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap canh 3: ");
        double c = Double.parseDouble(sc.nextLine());

        triangle1.setSide1(a);
        triangle1.setSide2(b);
        triangle1.setSide3(c);
        triangle1.setColor("Red");
        System.out.println(triangle1);

        Triangle triangle2 = new Triangle("yellow",1.2,2.1,3.7);
        System.out.println(triangle2);

    }
}
