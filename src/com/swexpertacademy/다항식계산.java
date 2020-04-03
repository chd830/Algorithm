package com.swexpertacademy;

import java.util.Scanner;
import java.util.Stack;

//테스트케이스는 돌아가는데 제한시간 초과가 납니다.
public class 다항식계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            String[] arr = new String[50+1];
            arr[0] = "1";
            arr[1] = "x";
            for(int i = 2; i <= N; i++) {
                int t = sc.nextInt();
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                switch (t) {
                    case 1:
                        arr[i] = arr[num1] +"+"+ arr[num2];
                        break;
                    case 2:
                        arr[i] = "("+num1+")"+"*("+arr[num2]+")";
                        break;
                    case 3:
                        arr[i] = "("+arr[num1]+")" +"*"+ "("+arr[num2]+")";
                        break;
                }
            }
            int M = sc.nextInt();
            int[] x = new int[M];
            for(int i = 0; i < M; i++) {
                x[i] = sc.nextInt();
            }
            System.out.print("#"+test_case+" ");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++) {
                String str = arr[N];
                str = str.replaceAll("x", ""+x[i]);
                Stack<Character> stack = new Stack<>();
                for(char c : str.toCharArray()) {
                    switch(c) {
                        case '+':
                            while(!stack.isEmpty() && stack.peek() != '(') {
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                            break;
                        case '*':
                            while(!stack.isEmpty() && stack.peek() != '+' && stack.peek() != '(') {
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                            break;
                        case '(':
                            stack.push(c);
                            break;
                        case ')':
                            while(!stack.isEmpty() && stack.peek() != '('){
                                sb.append(stack.pop());
                            }
                            stack.pop();
                            break;
                        default:
                            sb.append(c);
                            break;
                    }
                }
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                Stack<Integer> result = new Stack<>();
                for(char c : sb.toString().toCharArray()) {
                    int num1;
                    int num2;
                    switch(c) {
                        case '+':
                            num1 = result.pop();
                            num2 = result.pop();
                            result.push(num1%998244353 + num2%998244353);
                            break;
                        case '*':
                            num1 = result.pop();
                            num2 = result.pop();
                            result.push(num1%998244353 * num2%998244353);
                            break;
                        default:
                            result.push((c-48));
                            break;
                    }
                }
                System.out.print(result.pop()+" ");
            }
            System.out.println();
        }
    }
}
