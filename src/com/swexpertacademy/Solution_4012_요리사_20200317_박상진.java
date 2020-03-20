package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_요리사_20200317_박상진 {
    static int N, min;
    static int[][] map;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visit = new boolean[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            comb(0, 0);
            System.out.println("#" + tc + " " + min);
        }
        br.close();
    }

    static void comb(int cnt, int cur) {
        if (cur >= N) return;
        if (cnt == N / 2) {
            int sum1 = 0;
            int sum0 = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visit[i] != visit[j]) continue;
                    if (visit[i]) sum1 += map[i][j] + map[j][i];
                    else sum0 += map[i][j] + map[j][i];
                }
            }
            min = Math.min(min, Math.abs(sum1 - sum0));
            return;
        }
        for (int i = cur; i < N; i++) {
            visit[i] = true;
            comb(cnt + 1, i + 1);
            visit[i] = false;
        }
    }
}