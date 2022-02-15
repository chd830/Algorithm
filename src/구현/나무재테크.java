package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16235
public class 나무재테크 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int age;
        Node(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.age, o.age);
        }
    }
    static int N;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[][] ground = new int[N][N];
        int[][] add = new int[N][N];

        for(int i = 0; i < N; i++) {
            Arrays.fill(ground[i], 5);
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                add[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        PriorityQueue<Node> que = new PriorityQueue<>();
        Queue<Node> alive = new LinkedList<>();
        Queue<Node> dead = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            int age = Integer.parseInt(token.nextToken());
            que.add(new Node(x-1, y-1, age));
        }
        while(K-- > 0) {
            //봄: 나이만큼 양분을 먹고 나이 1 증가.
            while (!que.isEmpty()) {
                Node n = que.poll();
                if (ground[n.x][n.y] >= n.age) {
                    ground[n.x][n.y] -= n.age;
                    n.age++;
                    alive.add(n);
                } else
                    dead.add(n);
            }
            //여름: 봄에 죽은 나무가 양분으로 변함.
            while (!dead.isEmpty()) {
                Node n = dead.poll();
                ground[n.x][n.y] += n.age / 2;
            }
            //가을: 나무 번식
            while (!alive.isEmpty()) {
                Node n = alive.poll();
                if (n.age % 5 == 0) {
                    for (int d = 0; d < 8; d++) {
                        int dx = n.x + dir[d][0];
                        int dy = n.y + dir[d][1];
                        if (isIn(dx, dy)) {
                            que.add(new Node(dx, dy, 1));
                        }
                    }
                }
                que.add(n);
            }
            //겨울: 양분 추가
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    ground[i][j] += add[i][j];
                }
            }
        }
        System.out.println(que.size());
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
