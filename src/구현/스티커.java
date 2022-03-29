package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9465
public class 스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];
            for(int i = 0; i < 2; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            // 현재위치를 떼는 방법으로만 접근해서 최고값을 찾아보자
            int[][] d = new int[4][N+1];
            d[1][1] = arr[0][0];
            d[2][1] = arr[1][0];
            for(int j = 2; j <= N; j++) {
                d[1][j] = Math.max(d[2][j-1], d[2][j-2])+arr[0][j-1];
                d[2][j] = Math.max(d[1][j-1], d[1][j-2])+arr[1][j-1];
            }
            sb.append(Math.max(d[1][N], d[2][N])).append("\n");
        }
        System.out.println(sb.toString());
    }
}
