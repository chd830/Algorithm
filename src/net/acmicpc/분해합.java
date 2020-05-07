package net.acmicpc;

import java.util.Scanner;

public class 분해합 {
    static int N;
    static int result;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1];
        result = 0;
        arr[0] = 0;
        recur(1, 1);
        System.out.println((result == 0 ? 0 : result-1));
    }
    public static void recur(int n, int idx) {
        if(idx == arr.length) {
            return;
        }
        if(arr[idx-1] == N) {
            result = n;
            return;
        }
        arr[idx] = n;
//        System.out.print(n+" + ");
        int num = n;
        while(n >= 10) {
            arr[idx] += (n%10);
//            System.out.print(n%10+" + ");
            n /= 10;
        }
        arr[idx] += n;
//        System.out.println(n+" = "+island[idx]);
        recur(num+1, idx+1);
    }
}
