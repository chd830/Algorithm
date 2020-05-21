package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 키순서 {
    static boolean[] v;
    static int[][] map;
    static int result;
    static int cnt;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            map = new int[N+1][N+1];
            for(int i = 0; i < M; i++) {
                token = new StringTokenizer(br.readLine());
                map[Integer.parseInt(token.nextToken())][Integer.parseInt(token.nextToken())] = 1;
            }
            result = 0;
            for(int i = 1; i<= N; i++) {
                //나보다 큰사람 세기
                //나보다 작은사람 세기
                cnt = 0;
                v = new boolean[N+1];
                dfs(i);
                dfs1(i);
                if(cnt == N-1) {
                    result++;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs1(int idx) {
        v[idx] = true;
        for(int i = 1; i <= N; i++) {
            if(v[i]) {
                continue;
            }
            if(map[i][idx] == 0) {
                continue;
            }
            cnt++;
            dfs1(i);
        }
    }
    static void dfs(int idx) {
        v[idx] = true;
        for(int i = 1; i <= N; i++) {
            if(v[i]) {
                continue;
            }
            if(map[idx][i] == 0) {
                continue;
            }
            cnt++;
            dfs(i);
        }
    }
}
