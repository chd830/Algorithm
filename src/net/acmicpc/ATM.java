package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] p = new int[N];
        for(int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
        }
        Arrays.sort(p);
        for(int i = 1; i < N; i++) {
            p[i] += p[i-1];
        }
        for(int i = 1; i < N; i++) {
            p[i] += p[i-1];
        }
        System.out.println(p[N-1]);
    }
}
