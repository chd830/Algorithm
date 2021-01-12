package review;

import java.util.*;
import java.io.*;

public class 토마토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] maps = new int[M][N];
        boolean check = false;
        int cnt = 0;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int days = 0;
        Queue<Node> que = new LinkedList<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(token.nextToken());
                if(maps[i][j] == 1) {
                    que.add(new Node(i, j));
                    cnt++;
                }
                else if(maps[i][j] == -1) {
                    cnt++;
                }
            }
        }

        while(!que.isEmpty()) {
            int size = que.size();
            if(cnt == N*M) {
                check = true;
                break;
            }
            while(size-- > 0) {
                Node n = que.poll();
                for(int d = 0; d < 4; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx < M && dy < N && maps[dx][dy] == 0) {
                        maps[dx][dy] = 1;
                        cnt++;
                        que.add(new Node(dx, dy));
                    }
                }
            }
            days++;
        }
        System.out.println(check ? days : -1);
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
