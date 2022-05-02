package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16918
public class 봄버맨 {
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());
        char[][] arr = new char[R][C];
        int[][] map = new int[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'O')
                    map[i][j] = 3;
            }
        }
        int time = 0;
        while(time++ < N) {
            if(time%2 == 0) {
                for(int i = 0; i < R; i++) {
                    for(int j = 0; j < C; j++) {
                        if(arr[i][j] == '.') {
                            arr[i][j] = 'O';
                            map[i][j] = time+3;
                        }
                    }
                }
            }
            else if(time%2 == 1) {
                for(int i = 0; i < R; i++) {
                    for(int j = 0; j < C; j++) {
                        if(map[i][j] == time) {
                            arr[i][j] = '.';
                            for(int d = 0; d < 4; d++) {
                                int dx = i+dir[d][0];
                                int dy = j+dir[d][1];
                                if(dx >= 0 && dy >= 0 && dx < R && dy < C && arr[dx][dy] == 'O' && map[dx][dy] != time) {
                                    arr[dx][dy] = '.';
                                    map[dx][dy] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++)
                sb.append(arr[i][j]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}