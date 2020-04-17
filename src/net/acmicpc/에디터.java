package net.acmicpc;

import java.util.Scanner;
import java.util.Stack;

//List나 String을 사용하면 시간초과
public class 에디터 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for(char c : str.toCharArray()) {
            left.add(c);
        }
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            switch (sc.next()) {
                case "L":
                    if(!left.isEmpty()) {
                        right.add(left.pop());
                    }
                    break;
                case "D":
                    if(!right.isEmpty()) {
                        left.add(right.pop());
                    }
                    break;
                case "B":
                    if(!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case "P":
                    left.add(sc.next().charAt(0));
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty()) {
            sb.append(left.pop());
        }
        sb = sb.reverse();
        while(!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}