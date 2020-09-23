package net.acmicpc.re;

import java.util.*;
import java.io.*;

public class 단지번호붙이기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }
        int cnt = 0;
        List<Integer> house = new ArrayList();
        Queue<Node> que = new LinkedList();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    int count = 1;
                    cnt++;
                    visited[i][j] = true;
                    que.add(new Node(i, j));
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < N && dy < N && map[dx][dy] == 1 && !visited[dx][dy]) {
                                visited[dx][dy] = true;
                                que.add(new Node(dx, dy));
                                count++;
                            }
                        }
                    }
                    house.add(count);
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(house);
        for(int h : house) {
            System.out.println(h);
        }
    }
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
