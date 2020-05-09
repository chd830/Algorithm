package net.acmicpc;

import java.util.*;

public class 아기상어 {
    static int N;
    static Node start;
    static int[][] map;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static class Node {
        int x;
        int y;
        int size;
        int cnt;
        Node(int x, int y, int size, int cnt) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "("+x+", "+y+"): "+size+". "+cnt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9) {
                    start = new Node(i, j, 2, 0);
                    continue;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        int sum = 0;
        for(int i = 1; i < max; i++) {
            if(start.size > i) {
                sum += search(i);
            }
            System.out.println(sum);
        }
    }

    static int search(int size) {
        int sum = 0;
        int eat = 0;
        boolean[][] visited = new boolean[N][N];
        Queue<Node> que = new LinkedList<>();
        que.add(start);
        visited[start.x][start.y] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                int dx = n.x + dir[i][0];
                int dy = n.y + dir[i][1];
                if(isIn(dx, dy) && !visited[dx][dy]) {
                    if(map[dx][dy] != 0 && map[dx][dy] == size) {
                        sum += n.cnt+1;
                        eat++;
                    }
                    if(eat == size) {
                        start.size++;
                        eat = 0;
                    }
                    if(map[dx][dy] < start.size) {
                        que.add(new Node(dx, dy, map[dx][dy], n.cnt + 1));
                    }
                    visited[dx][dy] = true;
                }
            }
        }
        return sum;
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}