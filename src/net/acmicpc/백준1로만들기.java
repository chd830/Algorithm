package net.acmicpc;

import java.util.Scanner;

public class 백준1로만들기 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[1000001];
        int N = sc.nextInt();
        arr[1] = 0;
        for(int i = 2; i <= N; i++) {
            arr[i] = arr[i-1] + 1;
            if(i%2 == 0) {
                arr[i] = Math.min(arr[i], arr[i/2] + 1);
            }
            if(i%3 == 0) {
                arr[i] = Math.min(arr[i/3] + 1, arr[i]);
            }
        }
        System.out.println(arr[N]);
    }
}
