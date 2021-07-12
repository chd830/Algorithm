package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 1932
public class 정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N][N];
        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++)
            Arrays.fill(d[i], -1);
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                d[i][j] = Integer.parseInt(token.nextToken());
                result[i][j] = d[i][j];
            }
        }
        result[0][0] = d[0][0];
        for(int i = 1; i < N; i++) {
            result[i][0] = d[i][0]+result[i-1][0];
            for(int j = 1; j < i; j++) {
                result[i][j] += Math.max(result[i-1][j-1],result[i-1][j]);
            }
            result[i][i] += result[i-1][i-1];
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, result[N-1][i]);
        }
        System.out.println(max);
    }
}
