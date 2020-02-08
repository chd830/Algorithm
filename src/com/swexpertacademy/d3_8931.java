package com.swexpertacademy;

import java.util.*;

//제로
public class d3_8931 {
//    public static void main(String[] args) {
    d3_8931() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++ ){
            int K = sc.nextInt();
            Stack<Integer> stack = new Stack<Integer>();
            for(int i = 0; i < K; i++) {
                int num = sc.nextInt();
                if(num == 0 && !stack.isEmpty()) {
                    stack.pop();
                }
                else {
                    stack.push(num);
                }
            }
            int sum = 0;
            while(!stack.isEmpty()) {
                sum += stack.pop();
            }
            System.out.println("#"+t+" "+sum);
        }
    }
}
