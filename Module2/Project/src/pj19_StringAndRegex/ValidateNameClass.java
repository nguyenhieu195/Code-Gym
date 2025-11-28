package pj19_StringAndRegex;

import java.util.Scanner;

public class ValidateNameClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Name CL: ");
        String nameCL = scanner.nextLine();

        String nameRegex = "^(1[0-2]|[1-9])[A-Za-z]{1}[0-9]*$";

        while (!nameCL.matches(nameRegex)) {
            System.out.println("Invalid Name Cl !");
            System.out.print("Enter your Name CL: ");
            nameCL = scanner.nextLine();
        }

        System.out.println("Your Name Cl: " + nameCL);
        System.out.println("DONE !");
    }
}
