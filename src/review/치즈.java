package review;

import java.util.*;
import java.io.*;

public class 치즈 {
    static int N;
    static int M;
    static int prev;
    static int melt;
    static int cheese;
    static int[][] maps;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        maps = new int[N][M];

        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(token.nextToken());
                if(maps[i][j] == 1) {
                    cheese++;
                }
                if(i == 0 || j == 0 || i == N || j == M) {
                    visited[i][j] = true;
                }
            }
        }
        int time = 0;
        while(cheese != 0) {
            prev = cheese;
//            System.out.print(cheese +"\t");
            checkCheese();
            next();
//            System.out.println(melt+"\t"+prev);
            cheese -= melt;
            time++;
        }
        System.out.println(time);
        System.out.println(prev);
    }
    static void checkCheese() {
        int cnt = 0;
        visited = new boolean[N][M];
        Queue<Node> que = new LinkedList<>();
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length; j++) {
                if(i == 0 || j == 0 || i == N || j == M) {
                    que.add(new Node(i, j));
                }
            }
        }
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    if(maps[dx][dy] == 0) {
                        que.add(new Node(dx, dy));
                    }
                    else if(maps[dx][dy] == 1) {
                        cnt++;
                        maps[dx][dy] = 2;
                    }
                }
            }
        }
        melt = cnt;
    }
    static void next() {
        int cnt = 0;
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(maps[i][j] == 2) {
                    cnt++;
                    maps[i][j] = 0;
                }
            }
        }
        melt = cnt;
    }
    static void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x+", "+y;
        }
    }
}
