package net.acmicpc;

import java.util.Scanner;

public class 타일 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] D = new int[1000002];
        int size = sc.nextInt();
        D[1] = 1;
        D[2] = 2;
        if(size <= 2) {
            System.out.println(D[size]);
            System.exit(0);
        }
        for(int i = 3; i <= size; i++) {
            D[i] = (D[i-2]+D[i-1])%15746;
        }
        System.out.println(D[size]);
    }
}
