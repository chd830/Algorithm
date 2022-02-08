package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2665
public class 미로만들기 {

    static int N;
    static int min;
    static int[][] arr;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] cnt;
    static class Node {
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        min = Integer.MAX_VALUE;
        cnt = new int[N][N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                cnt[i][j] = 5000;
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0));
        cnt[0][0] = 0;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == N-1 && n.y == N-1) {
                min = Math.min(min, cnt[N-1][N-1]);
                continue;
            }
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < N && cnt[n.x][n.y] < cnt[dx][dy]) {
                    if(arr[dx][dy] == 0) {
                        cnt[dx][dy] = cnt[n.x][n.y]+1;
                        que.add(new Node(dx, dy, n.cnt+1));
                    }
                    else {
                        cnt[dx][dy] = cnt[n.x][n.y];
                        que.add(new Node(dx, dy, n.cnt));
                    }
                }
            }
        }
        System.out.println(min);
    }
}
