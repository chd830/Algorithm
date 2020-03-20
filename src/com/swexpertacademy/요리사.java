package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 요리사 {
    static int N;
    static int min;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#"+t+" ");
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            min = Integer.MAX_VALUE;
            visited = new boolean[N];
            for(int i = 0; i < N; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            combination(0, 0);
            sb.append(min+"\n");
        }
        System.out.println(sb);
        br.close();
    }
    static void combination(int cnt, int cur) {
        if(cur >= N) {
            return;
        }
        if(cnt == N/2) {
            int sum1 = 0;
            int sum0 = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] != visited[j]) continue;
                    if (visited[i]) sum1 += map[i][j] + map[j][i];
                    else sum0 += map[i][j] + map[j][i];
                }
            }
            min = Math.min(min, Math.abs(sum1 - sum0));
            return;
        }
        for(int i = cur; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(cnt+1, i+1);
                visited[i] = false;
            }
        }
    }
}
