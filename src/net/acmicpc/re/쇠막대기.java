package net.acmicpc.re;

import java.util.*;
import java.io.*;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sticks = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for(int i = 0; i < sticks.length(); i++) {
            char c = sticks.charAt(i);
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    //우선 하나를 빼고
                    stack.pop();
                    //레이저면 값을 더하고
                    if(sticks.charAt(i-1) == '(') {
                       result += stack.size();
                    }
                    //레이저가 아니면 끝이므로 하나를 더해준다.
                    else {
                        result++;
                    }
                    break;
            }
        }

        System.out.println(result);
    }
}
