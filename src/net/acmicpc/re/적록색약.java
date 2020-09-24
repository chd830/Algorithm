package net.acmicpc.re;

import java.util.*;
import java.io.*;

public class 적록색약 {
    static int N;
    static char[][] map;
    static char[][] colorweak;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        colorweak = new char[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                colorweak[i][j] = map[i][j] == 'G' || map[i][j] == 'R' ? 'R' : 'B';
            }
        }
        System.out.println(bfs(map)+" "+bfs(colorweak));
    }

    static int bfs(char[][] map) {
        char c = map[0][0];
        Queue<Node> que = new LinkedList();
        visited = new boolean[N][N];

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    cnt++;
                    c = map[i][j];
                    que.add(new Node(i, j));
                    visited[i][j] = true;
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < N && dy < N && map[dx][dy] == c && !visited[dx][dy]) {
                                visited[dx][dy] = true;
                                que.add(new Node(dx, dy));
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
