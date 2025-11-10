package pj13_Search;

import java.util.Objects;
import java.util.Scanner;

public class timDoPhucTapThuatToan {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = scanner.nextLine();

        char maxChar = ' ';
        int maxCount = 0;
        char x;
        int count;
        for (int i = 0; i < s.length(); i++) {
            x = s.charAt(i);
            count = 0;
            for (int j = 0; j < s.length(); j++) {
                if(Objects.equals(x, s.charAt(j))) count++;
            }
            if(count > maxCount){
                maxCount = count;
                maxChar = x;
            }
        }

        System.out.println("Xuat hien nhieu nhat: '" + maxChar + "', voi so lan xuat hien:  " + maxCount);

    }
}
