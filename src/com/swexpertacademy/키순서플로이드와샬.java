package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 키순서플로이드와샬 {
    static int[][] map;
    static int result;
    static int INF = 999999;
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
            map = new int[N + 1][N + 1];
            for(int[] arr : map) {
                Arrays.fill(arr, INF);
            }
            for (int i = 0; i < M; i++) {
                token = new StringTokenizer(br.readLine());
                map[Integer.parseInt(token.nextToken())][Integer.parseInt(token.nextToken())] = 1;
            }
            result = 0;
            for(int k = 1; k <= N; k++) {
                for(int i = 1; i <= N; i++) {
                    for(int j = 1; j <= N; j++) {
                        if(map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }
            int[] counts = new int[N+1];
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(map[i][j] != INF) {
                        counts[i]++;
                        counts[j]++;
                    }
                }
            }
            for(int i = 1; i <= N; i++) {
                if(counts[i] == N-1) {
                    result++;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
