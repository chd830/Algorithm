package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토7576 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "("+x+", "+y+")";
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());
        int[][] map = new int[N][M];
        Queue<Node> que = new LinkedList<>();
        int total = 0;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                if(map[i][j] == 1) {
                    total++;
                    que.add(new Node(i, j));
                }
                else if(map[i][j] == -1) {
                    total++;
                }
            }
        }
        int cnt = 0;
        while(!que.isEmpty()) {
            if(total == N*M) {
                break;
            }
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Node n = que.poll();
                for(int d = 0; d < 4; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] == 0) {
                        total++;
                        map[dx][dy] = 1;
                        que.add(new Node(dx, dy));
                    }
                }
            }
            cnt++;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(cnt);
    }
}
