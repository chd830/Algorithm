package com.swexpertacademy;

import java.io.*;
import java.util.*;

public class 오나의여신님re {
    static int N;
    static int M;
    static char[][] map;
    static int[][] cnt;
    static Queue<Node> que;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            map = new char[N][M];
            cnt = new int[N][M];
            que = new LinkedList<>();
            Node end = null;
            Node player = null;
            for(int i = 0; i < N; i++) {
                String str = br.readLine();
                for(int j = 0 ; j < M; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == 'S') {
                        player = new Node(i, j, false);
                    }
                    if(map[i][j] == '*') {
                        que.add(new Node(i, j, true));
                    }
                    if(map[i][j] == 'D') {
                        end = new Node(i, j, false);
                    }
                }
            }
            //player를 따로 넣어주지 않으면 하나의 테스트케이스가 통과하지 못함
            que.add(player);
            outer: while(!que.isEmpty()) {
                int size = que.size();
                for(int i = 0; i < size; i++) {
                    Node n = que.poll();

                    for(int j = 0; j < 4; j++) {
                        int dx = n.x + direction[j][0];
                        int dy = n.y + direction[j][1];

                        if(isIn(dx, dy)) {
                            if(n.isDevil) {
                                if(map[dx][dy] == '.' || map[dx][dy] == 'S') {
                                    map[dx][dy] = '*';
                                    que.add(new Node(dx, dy, true));
                                }
                            }
                            else {
                                if(map[dx][dy] == '.') {
                                    map[dx][dy] = 'S';
                                    cnt[dx][dy] = cnt[n.x][n.y]+1;
                                    que.add(new Node(dx, dy, false));
                                }
                                if(map[dx][dy] == 'D') {
                                    cnt[dx][dy] = cnt[n.x][n.y]+1;
                                    break outer;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("#"+t+" "+(cnt[end.x][end.y] == 0 ? "GAME OVER" : cnt[end.x][end.y]));
        }
    }


    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

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
}
