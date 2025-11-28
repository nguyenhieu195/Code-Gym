package pj2;

import java.util.Arrays;
import java.util.Scanner;

public class xoaPhanTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1,2,3,4,5,6,7,8};

        System.out.println("Nhap so phan tu muon xoa trong mang: ");
        int x = sc.nextInt();

        int[] newArr = new int[arr.length - 1];
        boolean check = false;
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != x) {
                newArr[j] = arr[i];
                j++;
                check = true;
            }
        }
        if (!check) {
            System.out.println("khong co phan tu " + x);
        } else {
            System.out.println("mang sau khi xoa: " + Arrays.toString(newArr));
        }

    }
}
