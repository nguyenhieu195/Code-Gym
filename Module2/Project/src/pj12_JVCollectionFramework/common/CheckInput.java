package pj12_JVCollectionFramework.common;

import java.util.Scanner;

public class CheckInput {
    private static final Scanner sc = new Scanner(System.in);

    public static int inputInt(String mess){
        while (true ){
            try{
                System.out.println(mess);
                int line = Integer.parseInt(sc.nextLine().trim());
                return line;
            }catch (Exception e){
                System.err.println("Vui lòng nhập số hợp lệ");
            }
        }
    }
}
