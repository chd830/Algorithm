package co.kr.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }
    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty())
                stack.push(c);
            else {
                if(stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
