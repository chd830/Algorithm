package net.acmicpc;

import java.util.*;

public class 섬의개수 {
    static int[][] map;
    static int area;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = -1;
        int num2 = -1;
        while (true) {
            String str = sc.nextLine();
            StringTokenizer token = new StringTokenizer(str);
            while (token.hasMoreTokens()) {
                num1 = Integer.parseInt(token.nextToken());
                num2 = Integer.parseInt(token.nextToken());
            }
            if (num1 == 0 && num2 == 0) {
                System.exit(0);
            }
            map = new int[num2][num1];
            area = 0;
            int cnt = 0;
            for(int i = 0; i < num2; i++) {
                for(int j = 0; j < num1; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i = 0; i < num2; i++) {
                for(int j = 0; j < num1; j++) {
                    if(map[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(area);
            System.out.println(cnt);
            sc.nextLine();
        }
    }

    static int[][] pos = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    public static void dfs(int x, int y) {
        map[x][y] = 0;
        for(int i = 0; i < 8; i++) {
            int dx = x + pos[i][0];
            int dy = y + pos[i][1];
            if(dx < 0 || dy < 0 || dx >= map.length || dy >= map[0].length) {
                continue;
            }
            if( map[dx][dy] == 0) {
                continue;
            }
            map[dx][dy] = 0;
            dfs(dx, dy);
        }
    }
    public static void bfs2(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 8; i++) {
                int dx = n.r + pos[i][0];
                int dy = n.c + pos[i][1];
                if(dx < 0 || dy < 0 || dx >= map.length || dy >= map[0].length) {
                    continue;
                }
                if( map[dx][dy] == 0) {
                    continue;
                }
                que.add(new Node(dx, dy));
                map[dx][dy] = 0;
            }
        }
    }

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        map[x][y] = 0;
        area++;
        while(!que.isEmpty()) {
            int[] num = que.poll();
            int curx = num[0];
            int cury = num[1];
            for(int i = 0; i < 8; i++) {
                int dx = curx + pos[i][0];
                int dy = cury + pos[i][1];
                if(dx < map.length && dx >= 0 && dy < map[0].length && dy >= 0 && map[dx][dy] == 1) {
                    que.add(new int[] {dx, dy});
                    map[dx][dy] = 0;
                }
            }
        }
    }
}
