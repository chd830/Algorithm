package net.acmicpc;

import java.util.Scanner;

public class 백준123더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[11];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;
        for(int i = 4; i < 11; i++) {
            result[i] = result[i-3] + result[i-2] + result[i-1];
        }
        for(int i = 0; i < T; i++) {
            System.out.println(result[sc.nextInt()]);
        }
    }
}
