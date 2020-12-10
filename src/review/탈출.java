package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출 {
    static class Node {
        int r;
        int c;
        int cnt;

        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());
        char[][] map = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        Queue<Node> hedge = new LinkedList<>();
        Queue<Node> water = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    hedge.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
                if (map[i][j] == '*') {
                    water.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        while (!hedge.isEmpty()) {
            int size = water.size();
            for(int i = 0; i < size; i++) {
                Node n = water.poll();
                for(int d = 0; d < 4; d++) {
                    int dx = n.r + dir[d][0];
                    int dy = n.c + dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx < R && dy < C && (map[dx][dy] =='.' || map[dx][dy] == 'S') && !visited[dx][dy]) {
                        visited[dx][dy] = true;
                        water.add(new Node(dx, dy, 0));
                        map[dx][dy] = '*';
                    }

                }
            }
            size = hedge.size();
            for(int i = 0; i < size; i++) {
                Node n = hedge.poll();
                for(int d = 0; d < 4; d++) {
                    int dx = n.r + dir[d][0];
                    int dy = n.c + dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx < R && dy < C && (map[dx][dy] != 'X' && map[dx][dy] != '*') && !visited[dx][dy]) {
                        if(map[dx][dy] == 'D') {
                            System.out.println(n.cnt+1);
                            System.exit(0);
                        }
                        visited[dx][dy] = true;
                        map[dx][dy] = 'S';
                        hedge.add(new Node(dx, dy, n.cnt+1));
                    }
                }
            }
//            for(int i = 0; i < R; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();
        }
        System.out.println("KAKTUS");
    }
}
