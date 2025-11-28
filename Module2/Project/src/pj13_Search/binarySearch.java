package pj13_Search;

import java.util.Arrays;
import java.util.Objects;

public class binarySearch {

    public static int binarysearch(int[] a, int left, int right, int value) {
        if(left > right) return -1;
        int mid = (left + right) / 2;
        if (a[mid] == value) return mid;

        if (value < a[mid]) return binarysearch(a, left, mid - 1, value);
        if(value > a[mid]) return binarysearch(a, mid + 1, right, value);
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 8, 6, 4, 2};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        int x = 9;
        System.out.println("phan tu can tim nam o vi tri: " + binarysearch(a, 0, a.length - 1, x));
    }
}
