package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class 파핑파핑지뢰찾기II {
    public static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};//상,우상,우,우하,하,좌하,좌,좌상
    public static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int N;
    public static char[][] m;
    public static boolean[][] v;


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_d4_1868.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            m = new char[N][N];
            v = new boolean[N][N];


            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    m[i][j] = s.charAt(j);
                }
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (m[i][j] != '.') continue;
                    if (count(i, j) == 0) {
                        ans++;
                        dfs(i, j);
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (m[i][j] == '.') ans++;
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
        br.close();
    }

    public static int count(int i, int j) {
        int mine = 0;
        for (int d = 0; d < 8; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && m[ni][nj] == '*') mine++;
        }
        return mine;
    }

    public static void dfs(int i, int j) {
        v[i][j] = true;
        int mine = count(i, j);
        m[i][j] = (char) (mine + '0');
        if (mine != 0) return;

        for (int d = 0; d < 8; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && m[ni][nj] == '.' && !v[ni][nj]) {
                dfs(ni, nj);
            }
        }
    }
}

