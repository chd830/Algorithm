package review;

import java.util.*;
import java.io.*;

public class 불5427 {
    static class Node {
        int x;
        int y;
        boolean fire;
        Node(int x, int y, boolean fire) {
            this.x = x;
            this.y = y;
            this.fire = fire;
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token = null;
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(token.nextToken());
            int N = Integer.parseInt(token.nextToken());
            char[][] map = new char[N][M];
            int[][] cnt = new int[N][M];
            // .공간 #벽 @시작위치 *불
            Node s = null;
            Queue<Node> que = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                String str = br.readLine();
                for(int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '@') {
                        s = new Node(i, j, false);
                        cnt[i][j] = 1;
                    }
                    else if(map[i][j] == '*') {
                        que.add(new Node(i, j, true));
                        cnt[i][j] = 1;
                    }
                }
            }
            que.add(s);
            boolean check = true;
            loop:while(!que.isEmpty()) {
                Node n = que.poll();
                if(map[n.x][n.y] == '@' && (n.x == 0 || n.y == 0 || n.x == N-1 || n.y == M-1)) {
                    check = false;
                    sb.append(cnt[n.x][n.y]).append("\n");
                    break loop;
                }
                for(int d = 0; d < 4; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx < N && dy < M && cnt[dx][dy] == 0) {
                        if(n.fire && (map[dx][dy] == '.' || map[dx][dy] == '@')) {
                            map[dx][dy] = '*';
                            cnt[dx][dy] = cnt[n.x][n.y]+1;
                            que.add(new Node(dx, dy, n.fire));
                        }
                        else if(!n.fire && map[dx][dy] =='.') {
                            map[dx][dy] = '@';
                            cnt[dx][dy] = cnt[n.x][n.y]+1;
                            que.add(new Node(dx, dy, n.fire));
                        }
                    }
                }
            }
//            print(map);
            if(check) {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }
        System.out.println(sb);
    }
    static void print(char[][] map) {
        for(int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
}
