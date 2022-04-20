package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11660
public class 구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        int[][] d = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                d[i][j] = d[i-1][j]+d[i][j-1]-d[i-1][j-1]+arr[i-1][j-1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int[] start = new int[] { Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()) };
            int[] end = new int[] { Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()) };
            sb.append(d[end[0]][end[1]]-d[end[0]][start[1]-1]-d[start[0]-1][end[1]]+d[start[0]-1][start[1]-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}