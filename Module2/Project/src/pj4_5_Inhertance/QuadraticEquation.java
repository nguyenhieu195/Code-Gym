package pj4_5_Inhertance;

import java.util.Scanner;

class calc {
    private double a;
    private double b;
    private double c;

    public calc(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public calc() {
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() { //
        return b * b - 4 * a * c;
    }

    public double getRoot1() {
        return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
    }

    public double getRoot2() {
        return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }
}

public class QuadraticEquation {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        calc q = new calc();

        double a, b, c;

        boolean valid = false;
        while (!valid) {
            try {
                System.out.println("Nhap a: ");
                a = Double.parseDouble(sc.nextLine());
                System.out.println("Nhap b: ");
                b = Double.parseDouble(sc.nextLine());
                System.out.println("Nhap c: ");
                c = Double.parseDouble(sc.nextLine());
                valid = true;
                q.setA(a);
                q.setB(b);
                q.setC(c);
            } catch (Exception e) {
                System.out.println("Phai nhap so !");
            }
        }
        double delta = q.getDiscriminant();
        if(delta > 0){
            double x1 = q.getRoot1();
            double x2 = q.getRoot2();
            System.out.println("PT co 2 nghiem: x1 = " + x1 + " x2 = " + x2 );
        } else if (delta == 0) {
            double x = q.getRoot1();
            System.out.println("PT co 1 nghiem kep: x = " + x);
        }else {
            System.out.println("PT vo nghiem !");
        }

    }
}
