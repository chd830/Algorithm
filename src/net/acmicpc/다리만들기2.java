package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기2 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int island;
    static int[][] map;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        island = 0;
        //섬의 개수를 찾기
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    island++;
                    Queue<Node> que = new LinkedList<>();
                    que.add(new Node(i, j));
                    map[i][j] = island;
                    visited[i][j] = true;
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int k = 0; k < 4; k++) {
                            int dx = n.x + dir[k][0];
                            int dy = n.y + dir[k][1];
                            if(isIn(dx, dy) && map[dx][dy] == 1 && !visited[dx][dy]) {
                                que.add(new Node(dx, dy));
                                visited[dx][dy] = true;
                                map[dx][dy] = island;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("섬의 개수: "+ island);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    makeGraph(i, j);
                }
            }
        }
    }
    static void makeGraph(int x, int y) {
        int base = map[x][y];
        for(int d = 0; d < 4; d++) {
            for(int l = 1; ; l++) {
                int dx = x + dir[d][0]*l;
                int dy = y + dir[d][1]*l;
                if(isIn(dx, dy)) {
                    if(map[dx][dy] == 0) {
                        continue;
                    }
                    else if(map[dx][dy] == base) {
                        continue;
                    }
                }
                else {
                    break;
                }
            }
        }
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}