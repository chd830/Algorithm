package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 빙산2573 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
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
//        print();
        int cnt = 0;
        int ice = countIce();
        while(ice == 1) {
            //빙산이 녹는 함수
            meltIce();
            ice = countIce();
            cnt++;
//            print();
        }
        System.out.println(ice  > 1 ? cnt : 0);
    }

    static void meltIce() {
        Queue<Node> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0) {
                    que.add(new Node(i, j));
                }
            }
        }
        while(!que.isEmpty()) {
            Node n = que.poll();
            visited[n.x][n.y] = true;
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if (dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy] && map[dx][dy] == 0) {
                    cnt++;
                }
            }
            map[n.x][n.y] -= cnt;
            if(map[n.x][n.y] < 0) {
                map[n.x][n.y] = 0;
            }
        }
    }

    static void print() {
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("빙산조각: "+countIce());
    }
    static int countIce() {
        int ice = 0;
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    ice++;
                    Queue<Node> que = new LinkedList<>();
                    que.add(new Node(i, j));
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for (int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy] && map[dx][dy] != 0) {
                                visited[dx][dy] = true;
                                que.add(new Node(dx, dy));
                            }
                        }
                    }
                }
            }
        }
        return ice;
    }
}
