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
        System.out.println(cnt);
    }
    public static void set(int idx, int num) {
        if(idx == N) {
            cnt++;
//            for(int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(arr[i]));
//            }
//            System.out.println();
            return;
        }
        for(int i = 0; i < num; i++) {
            if(isPossible(idx, i)) {
                arr[idx][i] = 1;
                set(idx+1, num);
                arr[idx][i] = 0;
            }
        }
    }
    public static boolean isPossible(int x, int y) {
        //왼쪽위
        for(int i = 0; x-i >= 0 && y-i >= 0; i++) {
            if(arr[x-i][y-i] == 1) {
                return false;
            }
        }
        //오른쪽위
        for(int i = 0; x-i >= 0 && y+i < N; i++) {
            if(arr[x-i][y+i] == 1) {
                return false;
            }
        }
        //위
        for(int i = x; i >= 0; i--) {
            if(arr[i][y] == 1) {
                return false;
            }
        }
        return true;
    }
}
