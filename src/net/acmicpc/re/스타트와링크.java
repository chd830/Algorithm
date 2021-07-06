package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 14889
public class 스타트와링크 {
    static int N;
    static int min;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        arr = new int[N][N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        comb(0, 0);
        System.out.println(min);
    }
    static void comb(int idx, int count) {
        if(count == N/2) {
            int sum1 = 0;
            int sum2 = 0;
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    // true일 때는 true만 체크하고 false일 때는 false만 체크할 수 있게 함.
                    if (visited[i] != visited[j])
                        continue;
                    if(visited[i])
                        sum1 += arr[i][j] + arr[j][i];
                    else
                        sum2 += arr[i][j] + arr[j][i];
                }
            }
            min = Math.min(min, Math.abs(sum1-sum2));
            return;
        }
        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(i+1, count+1);
                visited[i] = false;
            }
        }
    }
}
