package review;

import java.util.*;
import java.io.*;

// NM과 K(1)
public class acmicpc18290 {
    static int N;
    static int M;
    static int K;
    static int max;
    static int[][] arr;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        max = Integer.MIN_VALUE;
        arr = new int[N+2][M+2];

        for(int i = 1; i <= N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        visited = new boolean[N+2][M+2];
        dfs(0, 0);
        System.out.println(max);
    }

//    static class Value {
//        int x;
//        int y;
//        Value(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public String toString() {
//            return "x=" + x +
//                    ", y=" + y;
//        }
//    }
//    static List<Value> list = new ArrayList<>();
    static void dfs(int cnt, int sum) {
        if(cnt == K) {
            max = Math.max(max, sum);
//            for(Value i : list) {
//                System.out.print(i+"\t");
//            }
//            System.out.println(sum);
            return;
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(!visited[i][j] && can(i, j)) {
                    visited[i][j] = true;
//                    list.add(new Value(i, j));
                    dfs(cnt+1, sum+arr[i][j]);
//                    list.remove(list.size()-1);
                    visited[i][j] = false;
                }
            }
        }
    }
    static boolean can(int x, int y) {
        for(int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(visited[dx][dy])
                return false;
        }
        return true;
    }
}
