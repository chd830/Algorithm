package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //오른쪽 아래 왼쪽 위
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        for(int t = 1; t <= T; t++) {
            token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());
            int R = Integer.parseInt(token.nextToken());
            int C = Integer.parseInt(token.nextToken());
            int L = Integer.parseInt(token.nextToken());
            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            for(int i = 0; i < N; i++) {
                token = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            int time = 0;
            int cnt = 1;
            Queue<Node> que = new LinkedList<>();
            que.add(new Node(R, C));
            visited[R][C] = true;
            while(!que.isEmpty()) {
                if(time == L) {
                    break;
                }
                int size = que.size();
                for(int i = 0; i < size; i++) {
                    time++;
                    Node n = que.poll();
//                    System.out.println(n+" "+map[n.x][n.y]);
                    for(int d = 0; d < 4; d++) {
                        int dx = n.x + dir[d][0];
                        int dy = n.y + dir[d][1];
                        if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy] && map[dx][dy] != 0) {
                            switch (map[n.x][n.y]) {
                                case 1:
                                    if(d == 0 && (map[dx][dy] == 1 || map[dx][dy] == 3 || map[dx][dy] == 6 || map[dx][dy] == 7)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    if(d == 1 && (map[dx][dy] == 1 || map[dx][dy] == 2 || map[dx][dy] == 4 || map[dx][dy] == 7)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    if(d == 2 && (map[dx][dy] == 1 || map[dx][dy] == 3 || map[dx][dy] == 4 || map[dx][dy] == 5 )) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    if(d == 3 && (map[dx][dy] == 1 || map[dx][dy] == 2 || map[dx][dy] == 5 || map[dx][dy] == 6)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    break;
                                case 2:
                                    if(d == 1 && (map[dx][dy] == 1 || map[dx][dy] == 2 || map[dx][dy] == 4 || map[dx][dy] == 7)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    if(d == 3 && (map[dx][dy] == 1 || map[dx][dy] == 2 || map[dx][dy] == 5 || map[dx][dy] == 6)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    break;
                                case 3:
                                    if(d == 0 && (map[dx][dy] == 1 || map[dx][dy] == 3 || map[dx][dy] == 6 || map[dx][dy] == 7)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    if(d == 2 && (map[dx][dy] == 1 || map[dx][dy] == 3 || map[dx][dy] == 4 || map[dx][dy] == 5)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    break;
                                case 4:
                                    if(d == 0 && (map[dx][dy] == 1 || map[dx][dy] == 3 || map[dx][dy] == 6 || map[dx][dy] == 7)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    if(d == 3 && (map[dx][dy] == 1 || map[dx][dy] == 2 || map[dx][dy] == 5 || map[dx][dy] == 6)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    break;
                                case 5:
                                    if(d == 0 && (map[dx][dy] == 1 || map[dx][dy] == 3 || map[dx][dy] == 6 || map[dx][dy] == 7)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    if(d == 2 && (map[dx][dy] == 1 || map[dx][dy] == 2 || map[dx][dy] == 4 || map[dx][dy] == 7)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    break;
                                case 6:
                                    if(d == 1 && (map[dx][dy] == 1 || map[dx][dy] == 2 || map[dx][dy] == 4 || map[dx][dy] == 7)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    if(d == 2 && (map[dx][dy] == 1 || map[dx][dy] == 3 || map[dx][dy] == 4 || map[dx][dy] == 5)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    break;
                                case 7:
                                    if(d == 2 && (map[dx][dy] == 1 || map[dx][dy] == 3 || map[dx][dy] == 4 || map[dx][dy] == 5)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    if(d == 3 && (map[dx][dy] == 1 || map[dx][dy] == 2 || map[dx][dy] == 5 || map[dx][dy] == 6)) {
                                        que.add(new Node(dx, dy));
                                        visited[dx][dy] = true;
                                        cnt++;
//                                        System.out.println("Node{x="+dx+", y="+dy+"} "+map[dx][dy]);
                                    }
                                    break;
                            }
                        }
                    }
                }
//                System.out.println("------------------------");
            }

            System.out.println("#"+t+" "+cnt);
        }
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
