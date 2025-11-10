package pj11_Stack_Map_Queue;

import java.util.Stack;

public class thapPhanSangNhiPhan_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int n = 30;

        while (n > 0){
            stack.push(n%2);
            n /= 2;
        }

        String Output = "";

//        for(int value : stack){
//            Output += value;
//        }

        while (!stack.isEmpty()){
            Output += stack.pop();
        }

        System.out.println("Nhị phân của " + n + " la: " + Output);
    }
}
