package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1918
public class 후위표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> val = new HashMap<>();
        val.put('(', 0);
        val.put(')', 0);
        val.put('+', 1);
        val.put('-', 1);
        val.put('*', 2);
        val.put('/', 2);
        Stack<Character> oper = new Stack<>();
        String str = br.readLine();
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '+': case '-': case '*': case '/':
                    while(!oper.isEmpty() && val.get(oper.peek()) >= val.get(c))
                        answer += oper.pop();
                    oper.push(c);
                    break;
                case '(':
                    oper.push(c);
                    break;
                case ')':
                    while(!oper.isEmpty() && oper.peek() != '(')
                        answer += oper.pop();
                    oper.pop();
                    break;
                default:
                    answer += c;
            }
        }
        while(!oper.isEmpty())
            answer += oper.pop();
        System.out.println(answer);
    }
}
