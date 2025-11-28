package pj2;

import java.util.Arrays;
import java.util.Scanner;

public class themPhanTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1,2,3,4,5,6,7,8};

        System.out.println("Nhap so phan tu muon them vao mang: ");
        int x = sc.nextInt();
        System.out.println("Nhap vị trí phan tu muon them vao mang: ");
        int y = sc.nextInt();

        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < y; i++) {
            newArr[i] = arr[i];
        }
        newArr[y] = x;

        for (int i = y; i < arr.length; i++) {
            newArr[i+1] = arr[i];
        }
        System.out.println("mang sau khi them: " + Arrays.toString(newArr));
    }
}
