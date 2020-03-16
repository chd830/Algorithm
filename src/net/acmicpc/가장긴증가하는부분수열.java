package net.acmicpc;

import java.util.Scanner;

public class 가장긴증가하는부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {

            }
        }
        System.out.println(max);
    }
}
