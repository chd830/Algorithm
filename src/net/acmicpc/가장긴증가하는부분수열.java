package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 가장긴증가하는부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] d = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < N; i++) {
            d[i] = 1;
            for(int j = 0; j < i; j++) {
                //이전에 저장된 d 배열에서의  d[j]값보다 1크게 만든다.
                if(arr[j] < arr[i] && d[i] < d[j]+1) {
                    d[i] = d[j]+1;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, d[i]);
        }
        System.out.println(max);
    }
}
