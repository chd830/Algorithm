package review;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 안전영역 {
    static int N;
    static int max;
    static int area;
    static int[][] map;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        area = 0;
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                max = Math.max(map[i][j], max);
            }
        }
        for(int i = 1; i <= max; i++) {
            visited = new int[N][N];
            checkArea(i);
            countArea();
        }
        System.out.println(area == 0 ? 1 : area);
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void countArea() {
        int nums = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] == 1) {
                    nums++;
                    Queue<Node> que = new LinkedList<>();
                    que.add(new Node(i, j));
                    visited[i][j] = 2;
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < N && dy < N && visited[dx][dy] == 1) {
                                visited[dx][dy] = 2;
                                que.add(new Node(dx, dy));
                            }
                        }
                    }
                }
            }
        }
        area = Math.max(area, nums);
    }
    public static void checkArea(int num) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] > num) {
                    visited[i][j] = 1;
                }
            }
        }
    }
}
