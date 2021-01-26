package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 안전영역2468 {
    static int N;
    static int max;
    static int[][] map;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;
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
        StringTokenizer token;
        N = Integer.parseInt(br.readLine());
        max = 1;
        map = new int[N][N];
        int maxHeight = 0;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }
        // 배열에서 특정 높이이상의 지역의 수를 센다
        for(int i = 1; i < maxHeight; i++) {
            area(i);
        }
        System.out.println(max);
    }
    static void area(int height) {
        int cnt = 0;
        visited = new boolean[N][N];
        Queue<Node> que = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] > height) {
                    cnt++;
                    que.add(new Node(i, j));
                    visited[i][j] = true;
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < N && dy < N && !visited[dx][dy] && map[dx][dy] > height) {
                                visited[dx][dy] = true;
                                que.add(new Node(dx, dy));
                            }
                        }
                    }
                }
            }
        }
        max = Math.max(cnt, max);
    }
}