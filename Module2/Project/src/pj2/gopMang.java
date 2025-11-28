package pj2;

import java.util.Arrays;

public class gopMang {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {5, 6, 7, 8};

        int[] c = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[a.length + i] = b[i];
        }
        System.out.println("mang sau khi gop: " + Arrays.toString(c));
    }
}
