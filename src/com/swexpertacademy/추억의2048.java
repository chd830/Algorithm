package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 추억의2048 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            map = new int[N][N];
            String dir = token.nextToken();
            for(int i = 0; i < N; i++) {
                token = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            visited = new boolean[N][N];
            switch(dir) {
                case "up":
                    for(int j = 0; j < N; j++) {
                        for(int i = 1; i < N; i--) {
                            move(i, j, 0);
                        }
                    }
                    break;
                case "down":
                    for(int j = 0; j < N; j++) {
                        for(int  i = N-2; i >= 0; i--) {
                            move(i, j, 1);
                        }
                    }
                    break;
                case "left":
                    for(int i = 0; i < N; i++) {
                        for(int j = 1; j < N; j--) {
                            move(i, j, 2);
                        }
                    }
                    break;
                case "right":
                    for(int i = 0; i < N; i++) {
                        for(int j = N-2; j >= 0; j--) {
                            move(i, j, 3);
                        }
                    }
                    break;
            }
            for(int[] ma : map) {
                for(int m : ma) {
                    sb.append(m+" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
    public static void move(int i, int j, int d) {
        int dx = i + dir[d][0];
        int dy = j + dir[d][1];
        if(dx >= 0 && dy >= 0 && dx < N && dy < N && !visited[dx][dy]) {
            if(map[i][j] != 0 && map[i][j] == map[dx][dy]) {
                map[dx][dy] = map[i][j] * 2;
                map[i][j] = 0;
                visited[dx][dy] = true;
            }
            else if(map[dx][dy] == 0) {
                map[dx][dy] = map[i][j];
                map[i][j] = 0;
            }
            move(dx, dy, d);
        }
    }
}
