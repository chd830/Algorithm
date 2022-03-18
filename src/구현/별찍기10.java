package 구현;

import java.util.*;

// https://www.acmicpc.net/problem/2447
public class 별찍기10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];
        recur(0, 0, N, false);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static char[][] arr;
    static int N;
    static void recur(int x, int y, int N, boolean blank) {
        if(blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        if(N == 1) {
            arr[x][y] = '*';
            return;
        }
        int size = N/3;
        int cnt = 0;
        for(int i = x; i < x+N; i += size) {
            for(int j = y; j < y+N; j += size) {
                cnt++;
                if(cnt == 5)
                    recur(i, j, size, true);
                else
                    recur(i, j, size, false);
            }
        }
    }
}
