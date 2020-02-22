package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class NQueen {
    static int N;
    static int cnt;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cnt = 0;
        arr = new int[N][N];
        set(0, N);
    }
    public static void set(int idx, int num) {
        if(idx == N) {
            cnt++;
            for(int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < num; i++) {
            if(isPossibole(idx, i)) {
                arr[idx][i] = 1;
                set(idx+1, num);
                arr[idx][i] = 0;
            }
        }
    }
    public static boolean isPossibole(int x, int y) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[x][i] == 1) {
                return false;
            }
            if(arr[i][y] == 1) {
                return false;
            }
            for(int j = 0, num = x + y; j < arr.length ;j++) {
                if((i + j) == num && arr[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
