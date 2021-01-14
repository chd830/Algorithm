package review;

import java.util.*;
import java.io.*;

public class 보물섬 {

    static class Node {
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        char[][] map = new char[N][M];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 'L') {
                    visited = new boolean[N][M];
                    Queue<Node> que = new LinkedList<>();
                    que.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] == 'L' && !visited[dx][dy]) {
                                visited[dx][dy] = true;
                                max = Math.max(max, n.cnt+1);
                                que.add(new Node(dx, dy, n.cnt+1));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
