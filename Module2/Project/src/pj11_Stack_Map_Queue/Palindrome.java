package pj11_Stack_Map_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String inp = "12343291";

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < inp.length(); i++) {
            stack.push(inp.charAt(i));
            queue.add(inp.charAt(i));
        }
        boolean check = true;
        while (!stack.isEmpty()){
            char a = stack.pop();
            char b = queue.remove();
            if(a != b){
                check = false;
                break;
            }
        }

        System.out.println(check);
    }
}
