package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//어디에 단어가 들어갈 수 있을까
public class d2_1979 {
    static int[][] arr;
    static int N = 0;
    static int K = 0;
//    public static void main(String[] args) {
    public d2_1979() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int result = 0;
            arr = new int[N][N];
            String[] strs = new String[N];
            for(int i = 0; i < N; i++) {
                strs[i] = "";
                for(int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                    strs[i] += arr[i][j];
                }
            }
            for(int i = 0; i < strs.length; i++ ) {
                for(int j = 0; j < N - K; j++) {
                    System.out.print(strs[i].substring(j, j+K)+" ");
                    if(strs[i].substring(j, j+K).contains("0")) {
                        continue;
                    }
                    else {
                        if(j+K == N - 1 || j+K < N - 1 && strs[i].charAt(j+K+1) == '1') {
                            result++;
                            break;
                        }
                    }
                }
                System.out.println("\n"+strs[i]+", result: "+result);
            }
            System.out.println("#"+t+" "+result);
        }
    }
}
