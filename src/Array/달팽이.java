package Array;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1913
public class 달팽이 {
    static int N;
    static int K;
    static int i;
    static int j;
    static int idx;
    static int x;
    static int y;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N][N];
        idx = 1;
        i = N/2;
        j = N/2;
        int time = 1;
        int t = 1;
        arr[i][j] = idx++;
        --i;
        while(true) {
            time += 2;
            right(t);
            down(time-1);
            left(time-1);
            up(time);
            if(idx >= N*N)
                break;
            t += 2;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == K) {
                    x = i;
                    y = j;
                }
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(x+1).append(" ").append(y+1);
        System.out.println(sb.toString());
    }
    static void right(int time) {
        while(time-- > 0)
            arr[i][j++] = idx++;
    }
    static void down(int time) {
        while(time-- > 0)
            arr[i++][j] = idx++;
    }
    static void left(int time) {
        while(time-- > 0)
            arr[i][j--] = idx++;
    }
    static void up(int time) {
        while(time-- > 0)
            arr[i--][j] = idx++;
    }
}