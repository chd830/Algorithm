package review;

import java.util.*;
import java.io.*;

// 후위표기식
public class acmicpc1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String res = "";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '+': case '-': case '*': case '/':
                    while(!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                        res += stack.pop();
                    }
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        res += stack.pop();
                    }
                    stack.pop();
                    break;
                default:
                    res += c;
                    break;
            }
        }
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        System.out.println(res);
    }
    static int priority(char c) {
        switch (c) {
            case '*': case '/':
                return 2;
            case '+': case '-':
                return 1;
            case '(': case ')':
                return 0;
        }
        return -1;
    }
}
