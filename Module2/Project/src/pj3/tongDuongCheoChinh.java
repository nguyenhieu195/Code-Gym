package pj3;

import java.util.Scanner;

public class tongDuongCheoChinh {
//    1 1 1 1
//    1 1 1 1
//    1 1 1 1
//    1 1 1 1

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] a = {
                {1, 2, 4, 4},
                {5, 6, 7, 1},
                {1, 2, 10, 4},
                {5, 4, 7, 2}
        };

        int tong = 0;

        for (int i = 0; i < a.length; i++) {
            tong += a[i][i];
        }

        System.out.println("Tong: " + tong);
    }
}
