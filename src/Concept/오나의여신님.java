package Concept;

import java.util.*;

public class 오나의여신님 {
    static int N;
    static int M;
    static int[][] cnt;
    static char[][] map;
    static Queue<Node> que;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static class Node {
        int x;
        int y;
        boolean isDevil;
        Node(int x, int y, boolean isDevil) {
            this.x = x;
            this.y = y;
            this.isDevil = isDevil;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            sb.append("#"+t+" ");
            N = sc.nextInt();
            M = sc.nextInt();
            map = new char[N][M];
            cnt = new int[N][M];
            que = new LinkedList<>();
            Node god = null;
            Node player = null;
            for(int i = 0; i < N; i++) {
                String str = sc.next();
                for(int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '*') {
                        que.add(new Node(i, j, true));
                    }
                    if(map[i][j] == 'S') {
                        player = new Node(i, j, false);
                    }
                    if(map[i][j] == 'D') {
                        god = new Node(i, j, false);
                    }
                }
            }
            que.add(player);
            loop: while(!que.isEmpty()) {
                int size = que.size();
                for(int s = 0; s < size; s++) {
                    Node n = que.poll();
                    for(int i = 0; i < 4; i++) {
                        int dx = n.x + dir[i][0];
                        int dy = n.y + dir[i][1];
                        if(isIn(dx, dy) && cnt[dx][dy] == 0) {
                            if(n.isDevil && (map[dx][dy] == '.' || map[dx][dy] == 'S')) {
                                map[dx][dy] = '*';
                                que.add(new Node(dx, dy, true));
                            }
                            else if(!n.isDevil) {
                                cnt[dx][dy] = cnt[n.x][n.y]+1;
                                if(map[dx][dy] == '.') {
                                    map[dx][dy] = 'S';
                                    que.add(new Node(dx, dy, false));
                                }
                                else if(map[dx][dy] == 'D') {
                                    break loop;
                                }
                            }
                        }
                    }
                }
            }
            sb.append((cnt[god.x][god.y] == 0 ? "GAME OVER" : cnt[god.x][god.y])+"\n");
        }
        System.out.println(sb);
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
