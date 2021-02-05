package review;

import java.io.*;
import java.util.*;

public class 불 {
    // 불에 타기 전에 탈출 여부
    // 얼마나 빨리 탈출할 수 있는지 >> BFS
    // 벽# 공간. 초기위치J 불F
    static class Node {
        int x;
        int y;
        int cnt;
        boolean fire;
        Node(int x, int y, int cnt, boolean fire) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.fire = fire;
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());
        char[][] map = new char[R][C];
        Queue<Node> que = new LinkedList<>();
        Node jihun = null;
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'J') {
                    jihun = new Node(i, j, 1, false);
                }
                else if(map[i][j] == 'F') {
                    que.add(new Node(i, j, 1, true));
                }
            }
        }
        que.add(jihun);
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(!n.fire) {
                if(n.x == 0 || n.y == 0 || n.x == R-1 || n.y == C-1) {
                    System.out.println(n.cnt);
                    System.exit(0);
                }
            }
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < R && dy < C && map[dx][dy] != '#') {
                    if(n.fire && (map[dx][dy] == '.' || map[dx][dy] == 'J')) {
                        map[dx][dy] = 'F';
                        que.add(new Node(dx, dy, n.cnt+1, n.fire));
                    }
                    else if(!n.fire && map[dx][dy] == '.') {
                        map[dx][dy] = 'J';
                        que.add(new Node(dx, dy, n.cnt+1, n.fire));
                    }
                }
            }
//            print(map);
        }
        System.out.println("IMPOSSIBLE");
    }
//    static void print(char[][] arr) {
//        for(int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//        System.out.println();
//    }
}
