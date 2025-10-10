package pj3;

import java.util.Arrays;
import java.util.Scanner;

public class tongCacSoCotXacDinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Nhap so hang ");
//        int n = scanner.nextInt();
//        System.out.println("Nhap so cot ");
//        int m = scanner.nextInt();
//
//        int[][] a = new int[n][m];
//
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.println("a[" + (i + 1) + "][" + (j + 1) + "]");
//                a[i][j] = scanner.nextInt();
//            }
//        }

        int[][] a = {
                {1, 2, 4, 4},
                {5, 6, 7, 1},
                {1, 2, 2, 4},
                {5, 4, 7, 2}
        };

        System.out.println("Nhap so cot ma ban muon tinh tong");
        int x = scanner.nextInt();

        int tong = 0;
        for (int i = 0; i < a.length; i++) {
            tong += a[i][x];
        }

        System.out.println("Tong : " + tong);
    }
}
