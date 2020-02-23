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
        System.out.println(max+" "+min);
    }
    static int max;
    static int min;
    public static void operation(int idx) {
        if(idx == sub.length) {
            int[] result = new int[sub.length];
            for(int i = 0; i < N-1; i++) {
                switch (sub[i]) {
                    case '+':
                        if(i >= 1) {
                            result[i] = result[i-1] + arr[i+1];
                        }
                        else {
                            result[i] = arr[i] + arr[i + 1];
                        }
                        break;
                    case '-':
                        if(i >= 1) {
                            result[i] = result[i-1] - arr[i+1];
                        }
                        else {
                            result[i] = arr[i] - arr[i+1];
                        }
                        break;
                    case '*':
                        if(i >= 1) {
                            result[i] = result[i-1] * arr[i+1];
                        }
                        else {
                            result[i] = arr[i] * arr[i+1];
                        }
                        break;
                    case '/':
                        boolean isMinus = false;
                        if(arr[i+1] < 0) {
                            arr[i+1] *= -1;
                            isMinus = true;
                        }
                        if(i >= 1) {
                            result[i] = result[i-1]  / arr[i+1];
                        }
                        else {
                            result[i] = arr[i] / arr[i+1];
                        }
                        if(isMinus) {
                            result[i] *= -1;
                        }
                        break;
                }
            }
            max = Math.max(max, result[result.length-1]);
            min = Math.min(min, result[result.length-1]);
//            System.out.println("max: "+max+", min: "+min);
//            System.out.println(Arrays.toString(sub)+" "+result[sub.length-1]);
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
