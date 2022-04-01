package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2179
public class 숫자판점프 {
    static final int N = 5;
    static int[][] arr = new int[N][N];
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        for(int i = 0 ;i < N; i++) {
            for(int j = 0; j < N; j++) {
                find(i, j, "");
            }
        }
        System.out.println(set.size());
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static void find(int x, int y, String str) {
        if(str.length() == 6) {
            set.add(str);
            return;
        }
        for(int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(dx >= 0 && dy >= 0 && dx < N && dy < N) {
                find(dx, dy, str+arr[dx][dy]);
            }
        }
    }
}