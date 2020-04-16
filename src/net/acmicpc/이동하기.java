package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이동하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        int[][] result = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                if(i == 0 && j == 0) {
                    result[i][j] = map[i][j];
                    continue;
                }
                if(i == 0) {
                    result[i][j] = Math.max(map[i][j-1]+map[i][j], result[i][j-1]+map[i][j]);
                    continue;
                }
                if(j == 0) {
                    result[i][j] = result[i-1][j]+map[i][j];
                    continue;
                }
                result[i][j] = Math.max(result[i][j-1]+map[i][j],result[i-1][j]+map[i][j]);
            }
        }
        System.out.println(result[N-1][M-1]);
    }
}
