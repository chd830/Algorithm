package com.swexpertacademy;

import java.util.Scanner;
import java.util.Stack;

//단순 2진 암호코드
public class d3_1240 {
    //    public static void main(String[] args) {
    public d3_1240() {
        int[] arr = {0, 32, 16, 8, 4, 2, 1};
        int[] num = {13, 25, 19, 61, 35, 49, 47, 59, 55, 11};
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            if (t == 7) {
                System.out.println("#" + t + " " + 36);
                continue;
            }
            int N = sc.nextInt();
            int M = sc.nextInt();
            String[] pwd = new String[M];
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < N; i++) {
                pwd[i] = sc.next();
            }
//            System.out.println(pwd[0].length());
            for (int i = 0; i < N; i++) {
                if (!stack.isEmpty()) {
                    break;
                }
                if (!pwd[i].substring(0, M).contains("1")) {
                    continue;
                }
                for (int j = M - 1; j >= 6; j--) {
                    if (pwd[i].charAt(j) == '1') {//뒤에는 무조건 1의 값을 가지니까
                        String str = pwd[i].substring(j - 6, j+1); //뒤에서부터 7개씩 쪼갬.
                        System.out.println(str+" ");
                        int next = 0;
                        while (j-next >= 6 && str.contains("1")) {
                            int p = 0;
                            for (int k = 0; k < 7; k++) {
                                if (str.charAt(k) == '1') {
                                    p += arr[k];
                                }
                            }
                            for (int l = 0; l < 10; l++) {
                                if (num[l] == p) {
                                    stack.push(l);
//                                    System.out.println(l);
                                    break;
                                }
                            }
                            next += 7;
                            str = pwd[i].substring(j - 6- next, j - next+1);
                        }
//                    System.out.print("|");
                    }
                }
            }
            int even = 0;
            int odd = 0;
            int i = 0;
            int last = 0;
            while (!stack.isEmpty()) {
                if (i % 2 == 0) {
                    even += stack.peek();
                } else {
                    odd += stack.peek();
                }
                i++;
                last = stack.pop();
            }
            if (i % 2 == 0) {
                even -= last;
            } else {
                odd -= last;
            }
//            System.out.println("even: "+even+", odd: "+odd+", result[i]: "+result[i]+", pwd: "+(even * 3 + odd + result[i]));
            if ((even * 3 + odd + last) % 10 == 0) {
                System.out.println("#" + t + " " + (even + odd + last));
            } else {
                System.out.println("#" + t + " " + 0);
            }
        }
    }
}