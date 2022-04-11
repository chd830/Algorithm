package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1261
public class 알고스팟 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        int[][] wall = new int[N][M];
        for(int i = 0; i < N; i++)
            Arrays.fill(wall[i], 1234567);
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        wall[0][0] = arr[0][0] == 0 ? 0 : 1;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dx < N && dy >= 0 && dy < M) {
                    if(arr[dx][dy] == 1 && wall[dx][dy] > wall[n.x][n.y]+1) {
                        wall[dx][dy] = wall[n.x][n.y]+1;
                        que.add(new Node(dx, dy));
                    }
                    else if(arr[dx][dy] == 0 && wall[dx][dy] > wall[n.x][n.y]) {
                        wall[dx][dy] = wall[n.x][n.y];
                        que.add(new Node(dx, dy));
                    }
                }
            }
        }
        System.out.println(wall[N-1][M-1]);
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
