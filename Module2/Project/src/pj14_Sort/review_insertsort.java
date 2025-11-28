package pj14_Sort;

import java.util.Arrays;

public class review_insertsort {
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;

            System.out.print("Bước " + i + ": ");
            for (int k : a) System.out.print(k + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int []a = {1,2,4,3,6,7,5,9,0,7};

        System.out.println(Arrays.toString(a));

        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
