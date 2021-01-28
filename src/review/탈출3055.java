package review;

import java.util.*;
import java.io.*;

public class 탈출3055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // R, C
        // . 빈곳 * 물 D 비버 S 고슴도치
        StringTokenizer token = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());
        char[][] map = new char[R][C];
        Queue<Node> que = new LinkedList<>();
        Node hedge = null;
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S') {
                    hedge = new Node(i, j, 1, false);
                }
                else if(map[i][j] == '*') {
                    que.add(new Node(i, j, 0, true));
                }
            }
        }
        que.add(hedge);
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Node n = que.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if (dx >= 0 && dy >= 0 && dx < R && dy < C) {
                        if (n.water && map[dx][dy] == '.') {
                            que.add(new Node(dx, dy, n.cnt + 1, true));
                            map[dx][dy] = '*';
                        } else if (!n.water && map[dx][dy] == '.') {
                            que.add(new Node(dx, dy, n.cnt + 1, false));
                            map[dx][dy] = 'S';
                        } else if (!n.water && map[dx][dy] == 'D') {
                            System.out.println(n.cnt);
                            System.exit(0);
                        }
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }

    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Node {
        int x;
        int y;
        int cnt;
        boolean water;
        Node(int x, int y, int cnt, boolean water) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.water = water;
        }
    }
}
