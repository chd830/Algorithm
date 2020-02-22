package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 연산자끼워넣기 {
    static int N;
    static int cnt;
    static int[] arr;
    static char[] oper;
    static char[] sub;
    static int[] opers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cnt = 0;
        arr = new int[N];
        oper = new char[]{'+', '-', '*', '/'};
        opers = new int[4];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < 4; i++) {
            opers[i] = sc.nextInt();
            cnt += opers[i];
        }
        sub = new char[cnt];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        operation( 0);
    }
    static int max;
    static int min;
    public static void operation(int idx) {
        if(idx == sub.length) {
            int result = 0;
            for(int i = 0; i < N-1; i++) {
                switch (sub[i]) {
                    case '+':
                        result += (arr[i] + arr[i+1]);
                        break;
                    case '-':
                        result += (arr[i] - arr[i-1]);
                        break;
                    case '*':
                        result += (arr[i] * arr[i-1]);
                        break;
                    case '/':
                        break;
                }
            }
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < opers.length; i++) {
            if(opers[i] > 0) {
                sub[idx] = oper[i];
                opers[i]--;
                operation(idx+1);
                opers[i]++;
            }
        }
    }
}
