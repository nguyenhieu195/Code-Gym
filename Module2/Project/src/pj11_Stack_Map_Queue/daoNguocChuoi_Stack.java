package pj11_Stack_Map_Queue;

// đảo ngược chuỗi số nguyên dùng stack

import java.util.Arrays;
import java.util.Stack;

public class daoNguocChuoi_Stack {
    public static void main(String[] args) {
        int []a = {1,2,3,4,5,6,7,8,9,0};

        System.out.println(Arrays.toString(a));

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a.length; i++){
            stack.push(a[i]);
        }

        for (int i = 0; i < a.length; i++){
            a[i] = stack.pop();
        }

        System.out.println(Arrays.toString(a));
    }
}
