package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//단순 2진 암호코드
public class d3_1240 {
    //    public static void main(String[] args) {
    public d3_1240() {
        int[] arr = {0, 32, 16, 8, 4, 2, 1};
        int[] num = {13, 25, 19, 61, 35, 49, 47, 59, 55, 11};
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            String[] pwd = new String[M];
            int[] result = new int[N];
            Arrays.fill(result, 10);
            for (int i = 0; i < N; i++) {
                pwd[i] = sc.next();
            }
//            System.out.println(pwd[0].length());
            for (int i = 0; i < N; i++) {
//                System.out.println(pwd[i].substring(0, M/3));
                if (!pwd[i].substring(0, M / 2).contains("1")) {
                    continue;
                }
                check:
                for (int j = 0, l = 0, next = 0; j + 7 + next <= M; j++) {
                    String str = pwd[i].substring(j + next, j + 7 + next);
                    System.out.print("("+(j+next)+", "+(j+7+next)+") :"+str);
                    int p = 0;
                    System.out.print("|");
                    for (int k = 0; k < str.length(); k++) {
                        System.out.print(str.charAt(k)+"|");
                        if (str.charAt(k) == '1') {
                            System.out.print(" arr["+k+"]: "+arr[k]+" ");
                            p += arr[k];
                        }
                    }
                    System.out.println("\tp: "+p);
                    if (p >= 11) { //암호가 시작됨.
                        for (int k = 0; k < 9; k++) {
                            if (num[k] == p) {
                                result[l] = k;
                                next += 6;
                                l++;
                                continue check;
                            }
                        }
                    }
//                    if(result[i] == 10) {
//                        j++;
//                    }
//                    System.out.println(Arrays.toString(result));
                }
            }
//            System.out.println(Arrays.toString(result));
            int even = 0;
            int odd = 0;
            int i = 0;
            while(true) {
//            for (int i = 0; result[i+1] != 10 && i < result.length - 2; i++) {
                if(i < result.length - 1 && result[i+1] == 10) {
                    break;
                }
                if (i % 2 == 0) {
                    even += result[i];
                } else {
                    odd += result[i];
                }
                i++;
            }
            System.out.println(Arrays.toString(result));
            System.out.println("even: "+even+", odd: "+odd+", result[i]: "+result[i]+", pwd: "+(even * 3 + odd + result[i]));
            if ((even * 3 + odd + result[i]) % 10 == 0) {
                System.out.println("#" + t + " " + (even + odd + result[i]));
            } else {
                System.out.println("#" + t + " " + 0);
            }
        }
    }
}
