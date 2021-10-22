package net.acmicpc;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1662
public class 압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case ')':
                    int count = 0;
                    while(stack.peek() != -1) {
                        count += stack.pop();
                    }
                    stack.pop();
                    if(!stack.isEmpty())
                        stack.push(stack.pop()*count);
                    else
                        stack.push(count+'0');
                    break;
                case '(':
                    stack.push(-1);
                    break;
                default:
                    if(i+1 < str.length() && str.charAt(i+1) != '(')
                        stack.push(1);
                    else if(i == str.length()-1 && Character.isDigit(str.charAt(i)))
                        stack.push(1);
                    else
                        stack.push(c-'0');
                    break;
            }
        }
        while(!stack.isEmpty())
            answer += stack.pop();
        System.out.println(answer);
    }
}
