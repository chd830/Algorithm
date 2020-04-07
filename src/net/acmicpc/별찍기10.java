package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 별찍기10 {
    private static final Scanner sc = new Scanner(System.in);
    private static char[][] arr;
    static int N;

    public static void main(String args[]) {
        N = sc.nextInt();
        arr = new char[N][N];
        recur(0, 0, N);
        for(int i = 0; i < N; i++) {
            for(int j = 0;j < N; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void recur(int x, int y, int num) {
        int div = 0;
        if(num == 1) {
            arr[x][y] = '*';
            return;
        }
        div = num/3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) {
                    continue;
                }
                recur(x+(div*i), y+(div*j), div);
            }
        }
    }
}