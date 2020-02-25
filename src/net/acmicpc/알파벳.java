package net.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 알파벳 {
    static int R;
    static int C;
    static int[] alph;
    static char[][] map;
    static boolean[][] visited;
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        alph = new int[26];
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            String str = sc.next();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
//        bfs();
        alph[map[0][0] - 65]++;
        dfs(0, 0, 1);
        System.out.println(max);
    }
    static int max = 0;
    public static void dfs(int x, int y, int cnt) {
        max = Math.max(cnt, max);
        System.out.println(cnt);
        for(int i = 0; i < 4; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];
            if(dx >= 0 && dx < R && dy >= 0 && dy < R && alph[map[dx][dy]-65] == 0) {
                alph[map[dx][dy] - 65]++;
                visited[dx][dy] = true;
                dfs(dx, dy, cnt+1);
                alph[map[dx][dy] - 65]--;
                visited[dx][dy] = false;
            }
        }
    }
    /*
5 5
IEFCJ
FHFKC
FFALF
HFGCF
HMCHH

3 6
HFDFFB
AJHGDH
DGAGEH
     */
//    public static void bfs() {
//        Queue<Node> que = new LinkedList<>();
//        que.add(new Node(0, 0));
//        alph[map[0][0] - 65]++;
//        count[0][0] = 1;
//        while(!que.isEmpty()) {
//            Node n = que.poll();
//            if(n.left == R && n.right == C) {
//                return;
//            }
//            for(int i = 0; i < 4; i++) {
//                int dx = n.left + move[i][0];
//                int dy = n.right + move[i][1];
//                if(dx >= 0 && dy >= 0 && dx < R && dy < C && alph[map[dx][dy] - 65] == 0 && count[dx][dy] == 0) {
////                    System.out.print(map[dx][dy]+" ");
////                    System.out.println(Arrays.toString(alph));
//                    que.add(new Node(dx, dy));
//                    count[dx][dy] = count[n.left][n.right]+1;
//                    max = Math.max(count[dx][dy], max);
//                    alph[map[dx][dy] - 65]++;
//                }
//            }
//        }
////        System.out.println(Arrays.toString(alph));
//    }
}