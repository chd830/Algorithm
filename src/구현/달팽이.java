package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1913
public class 달팽이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        find = Integer.parseInt(br.readLine());
        idx = 1;
        arr = new int[N][N];
        x = N/2;
        y = N/2;
        arr[x][y] = idx++;
        x--;
        arr[x][y] = idx++;
        y++;
        snail();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        if(find == 1) {
            resultX = N/2;
            resultY = N/2;
        }
        else if(find == 2) {
            resultX = N/2-1;
            resultY = N/2;
        }
        sb.append(resultX+1).append(" ").append(resultY+1);
        System.out.println(sb.toString());
    }
    static int[][] arr;
    static int find;
    static int idx;
    static int N;
    static int x;
    static int y;
    static int resultX;
    static int resultY;

    static void snail() {
        int cnt = 2;
        while(cnt+1 <= N) {
            down(cnt+1);
            left(cnt);
            if(cnt+1 == N)
                up(cnt);
            else
                up(cnt+1);
            if(cnt+1 != N)
                right(cnt);
            cnt += 2;
        }
    }

    static void down(int cnt) {
        for(int i = 0; i < cnt; i++) {
            if(idx == find) {
                resultX = x;
                resultY = y;
            }
            arr[x++][y] = idx++;
        }
        x--;
        y--;
    }
    static void left(int cnt) {
        for(int i = 0; i < cnt; i++) {
            if(idx == find) {
                resultX = x;
                resultY = y;
            }
            arr[x][y--] = idx++;
        }
        x--;
        y++;
    }
    static void up(int cnt) {
        for(int i = 0; i < cnt; i++) {
            if(idx == find) {
                resultX = x;
                resultY = y;
            }
            arr[x--][y] = idx++;
        }
        x++;
        y++;
    }
    static void right(int cnt) {
        for(int i = 0; i < cnt; i++) {
            if(idx == find) {
                resultX = x;
                resultY = y;
            }
            arr[x][y++] = idx++;
        }
    }
}
