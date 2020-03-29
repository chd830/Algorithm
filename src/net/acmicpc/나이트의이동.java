package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동 {
    static int size;
    static Node end;
    static int[][] map;
    static int[][] cnt;
    static int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            size = sc.nextInt();
            map = new int[size][size];
            cnt = new int[size][size];
            Node start = new Node(sc.nextInt(), sc.nextInt());
            end = new Node(sc.nextInt(), sc.nextInt());
            bfs(start);
        }
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < size && dy < size;
    }
    static void bfs(Node start) {
        Queue<Node> que = new LinkedList<>();
        que.add(start);
        cnt[start.x][start.y] = 1;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == end.x && n.y == end.y) {
                System.out.println(cnt[n.x][n.y]-1);
                return;
            }
            for(int i = 0; i < dir.length; i++) {
                int dx = n.x + dir[i][0];
                int dy = n.y + dir[i][1];
                if(isIn(dx, dy) && cnt[dx][dy] == 0) {
                    que.add(new Node(dx, dy));
                    cnt[dx][dy] = cnt[n.x][n.y]+1;
                }
            }
        }
    }
}
