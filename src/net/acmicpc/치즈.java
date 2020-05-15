package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈 {
    static int N;
    static int M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        int prev = countCheese();
        int cur = prev;
        int cnt = 0;
        while(cur != 0) {
            checkBoundary();
            prev = cur;
            cnt++;
            cur = countCheese();
        }
        System.out.println(cnt);
        System.out.println(prev);
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void checkBoundary() {
        visited = new boolean[N][M];
        //가장자리에서 안쪽으로 들어오면서 치즈큐에 추가하고 모두 0으로 바꾼다.
        Queue<Node> que = new LinkedList<>();
        Queue<Node> cheese = new LinkedList<>();
        que.add(new Node(0, 0));
        visited[0][0] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    if(map[dx][dy] == 1) {
                        cheese.add(new Node(dx, dy));
                    }
                    if(map[dx][dy] == 0) {
                        que.add(new Node(dx, dy));
                    }
                }
            }
        }
        while(!cheese.isEmpty()) {
            Node n = cheese.poll();
            map[n.x][n.y] = 0;
        }
    }
    //치즈인 면적의 수를 센다.
    static int countCheese() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
